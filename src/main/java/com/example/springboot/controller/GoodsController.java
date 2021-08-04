package com.example.springboot.controller;


import com.example.springboot.mapper.GoodsMapper;
import com.example.springboot.pojo.Goods;
import com.example.springboot.pojo.Type;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @RequestMapping("getGoodsList")
    public List<Goods> list(String query, @RequestParam("pagenum") int num, @RequestParam("pagesize")int size){
        num=(num-1)*size;
        if(query.equals(""))
            query="%";
        return goodsMapper.queryGoodsList(query,num,size);
    }
   @RequestMapping("goodsCount")
    public int GoodsCount(String query){
        if(query.equals(""))
            query="%";
        return goodsMapper.queryGoodsCount(query);
    }
    @RequestMapping("addGoods")
    public void addGoods(Goods goods){
        goodsMapper.addGoods(goods.getName(),goods.getPrice(),goods.getNumber(),goods.getWeight(),goods.getDate(),goods.getValue(),goods.getIntroduce());
    }
    @RequestMapping("deleteGoods")
    public void deleteGoods(String name){
        goodsMapper.deleteGoods(name);
    }
    @RequestMapping("alterGoods")
    public void alterGoods(String name,String price,String number,String weight){
        goodsMapper.alterGoods(name,price,number,weight);
    }
    @RequestMapping("getGoodsType")
    public List<Type> getType(){
       return goodsMapper.getGoodsType();
    }
}
