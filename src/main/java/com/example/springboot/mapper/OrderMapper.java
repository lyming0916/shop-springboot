package com.example.springboot.mapper;

import com.example.springboot.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from sale where username like #{query} limit #{num},#{size} ")
    List<Order> queryOrderList(String query, int num, int size);
    @Select("select count(*) from sale where username like #{query}")
    int queryOrderCount(String query);
    @Insert("insert into sale values (#{username},#{goodsname},#{number},#{date})")
    void addOrder(String username,String goodsname,String number,String date);
    @Delete("delete from sale where username like #{username} and goodsname like #{goodsname} ")
    void deleteOrder(String username,String goodsname);
    @Select("select distinct goodsname from sale")
    String[] getGoodsType1();
    @Select("select sum(number) from sale group by goodsname")
    String[] getGoodsType2();
}
