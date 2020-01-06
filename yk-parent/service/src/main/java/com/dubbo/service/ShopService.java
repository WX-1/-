package com.dubbo.service;

import com.dubbo.pojo.Order;
import com.dubbo.pojo.Shop;
import com.github.pagehelper.PageInfo;

public interface ShopService {
    PageInfo<Shop> slist(String sname, int pageNum, int pageSize);

    void add(Shop shop);

    void upload(Integer sid, String img);

    void shangjia(Integer sid);

    Shop findById(Integer sid);

    void xiajia(Integer sid);

    Shop findOne(Integer sid);

    void oadd(Order order);
}
