package com.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.mapper.OrderMapper;
import com.dubbo.mapper.ShopMapper;
import com.dubbo.pojo.Order;
import com.dubbo.pojo.Shop;
import com.dubbo.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Shop> slist(String sname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> slist = shopMapper.slist(sname);
        PageInfo<Shop> pageInfo = new PageInfo<>(slist);
        return pageInfo;
    }

    @Override
    public void add(Shop shop) {
        shopMapper.add(shop);
    }

    @Override
    public void upload(Integer sid, String img) {
        shopMapper.upload(sid,img);
    }

    @Override
    public void shangjia(Integer sid) {
        shopMapper.shangjia(sid);
    }

    @Override
    public Shop findById(Integer sid) {
        return shopMapper.findById(sid);
    }

    @Override
    public void xiajia(Integer sid) {
        shopMapper.xiajia(sid);
    }

    @Override
    public Shop findOne(Integer sid) {

        return shopMapper.findOne(sid);
    }

    @Override
    public void oadd(Order order) {
        orderMapper.oadd(order);
    }
}
