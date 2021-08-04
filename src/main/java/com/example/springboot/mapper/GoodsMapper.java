package com.example.springboot.mapper;

import com.example.springboot.pojo.Goods;
import com.example.springboot.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    @Select("select * from goods where name like #{query} limit #{num},#{size} ")
    List<Goods> queryGoodsList(String query, int num, int size);
    @Select("select * from goods where name like  #{name}")
    Goods queryGoodsByName(@Param("name") String goodsname);
    @Select("select number from goods where name like #{name}")
    int queryGoodsCountByName(@Param("name") String goodsname);
    @Select("select count(*) from goods where name like #{query}")
    int queryGoodsCount(String query);
    @Insert("insert into goods values (#{name},#{price},#{number},#{weight},#{date},#{value},#{introduce})")
    void addGoods(String name,String price,String number,String weight,String date,String value,String introduce);
    @Delete("delete from goods where name like #{name}")
    void deleteGoods(String name);
    @Update("update goods set price=#{price},number=#{number},weight=#{weight} where name like #{name}")
    void alterGoods(String name,String price,String number,String weight);
    @Update("update goods set number=#{number} where name=#{name}")
    void alterGoodsCountByName(String name,String number);
    @Select("select * from type")
    List <Type> getGoodsType();
}
