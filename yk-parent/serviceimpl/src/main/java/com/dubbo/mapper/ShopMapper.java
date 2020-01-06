package com.dubbo.mapper;

import com.dubbo.pojo.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShopMapper extends Mapper<Shop> {
    @Select("select * from t_shop where sname like concat('%',#{sname},'%')")
    List<Shop> slist(String sname);

    @Insert("insert into t_shop(brand,type,sname,content,price,num,state) values(#{brand},#{type},#{sname},#{content},#{price},#{num},1)")
    void add(Shop shop);

    @Update("update t_shop set img=#{img} where sid=#{sid}")
    void upload(Integer sid, String img);

    @Update("update t_shop set state=2 where sid=#{sid}" )
    void shangjia(Integer sid);

    @Select("select * from t_shop where sid=#{sid}")
    Shop findById(Integer sid);

    @Update("update t_shop set state=1 where sid=#{sid}" )
    void xiajia(Integer sid);

    @Select("select * from t_shop where sid=#{sid}")
    Shop findOne(Integer sid);
}