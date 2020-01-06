package com.dubbo.mapper;

import com.dubbo.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    @Select("select * from t_order where oname like concat('%',#{oname},'%')")
    List<Order> list(String oname);

    @Insert("insert into t_order(count,sum,oname,tel,address,state) values(#{count},#{sum},#{oname},#{tel},#{address},1)")
    void oadd(Order order);
}