package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.pojo.Order;
import com.dubbo.pojo.Shop;
import com.dubbo.service.ShopService;
import com.dubbo.util.FileDownOrUpload;
import com.dubbo.util.Result;
import com.github.pagehelper.PageInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShopController {

    @Reference
    private ShopService shopService;

    //列表 分页 模糊
    @ResponseBody
    @RequestMapping("/slist")
    public PageInfo<Shop> slist(String sname, @RequestParam(defaultValue = "0")int pageNum, @RequestParam(defaultValue = "2")int pageSize){
        return shopService.slist(sname,pageNum,pageSize);
    }
    //添加
    @ResponseBody
    @RequestMapping("/add")
    public Result add(@RequestBody Shop shop){
        try {
            shopService.add(shop);
            return new Result("添加成功",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result("添加失败",false);
    }
    //上传
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file,Integer sid) throws Exception {
       String img = FileDownOrUpload.upload(file,request);
       shopService.upload(sid,img);
       return "redirect:html/slist.html";
    }

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    @Value("${mystatic}")
    private String us;

    //改变状态值 并且生成静态页
    @RequestMapping("/shangjia")
    @ResponseBody
    public void shangjia(Integer sid) throws Exception {
        shopService.shangjia(sid);
        Configuration configuration = freeMarkerConfig.getConfiguration();
        Template template = configuration.getTemplate("freemark.ftl");
        Map map = new HashMap();
        Shop shop = shopService.findById(sid);
        map.put("shop",shop);
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(us+sid+".html", Boolean.parseBoolean("utf-8"))));
        template.process(map,writer);
        writer.close();

    }
    //下架
    @RequestMapping("/xiajia")
    @ResponseBody
    public void xiajia(Integer sid) throws Exception {
        shopService.xiajia(sid);
    }
    //下单回显
    @ResponseBody
    @RequestMapping("/findOne")
    public Shop findOne(Integer sid){
        Shop shop = shopService.findOne(sid);
        return shop;
    }
    //下单添加
    @ResponseBody
    @RequestMapping("/oadd")
    public Result oadd(@RequestBody Order order){
        try {
            shopService.oadd(order);
            return new Result("添加成功",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result("添加失败",false);
    }

}
