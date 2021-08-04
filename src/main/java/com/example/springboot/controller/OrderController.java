package com.example.springboot.controller;


import com.example.springboot.mapper.GoodsMapper;
import com.example.springboot.mapper.OrderMapper;
import com.example.springboot.mapper.UserListMapper;
import com.example.springboot.pojo.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserListMapper userListMapper;

    @RequestMapping("getOrderList")
    public List<Order> list(String query, @RequestParam("pagenum") int num, @RequestParam("pagesize")int size){
        num=(num-1)*size;
        if(query.equals(""))
            query="%";
        return orderMapper.queryOrderList(query,num,size);
    }
    @RequestMapping("orderCount")
    public int GoodsCount(String query){
        if(query.equals(""))
            query="%";
        return orderMapper.queryOrderCount(query);
    }
    @RequestMapping("deleteOrder")
    public void deleteGoods(String username,String goodsname,String number){
        int a=goodsMapper.queryGoodsCountByName(goodsname);
        number=String.valueOf(a+Integer.parseInt(number));
        goodsMapper.alterGoodsCountByName(goodsname,number);
        orderMapper.deleteOrder(username,goodsname);
    }
    @RequestMapping("getGoodsType1")
    public String[] getGoodsType1(){
        return orderMapper.getGoodsType1();
    }
    @RequestMapping("getGoodsType2")
    public String[] getGoodsType2(){
        return orderMapper.getGoodsType2();
    }

    @RequestMapping("addOrder")
    public int addGoods(Order order){
        if(order.getUsername()==null||order.getGoodsname()==null||order.getNumber()==null||order.getDate()==null)
            return 1;
        else if(userListMapper.queryUserByName(order.getUsername())==null)
            return 2;
        else if(goodsMapper.queryGoodsByName(order.getGoodsname())==null)
            return 3;
        else if(Integer.parseInt(order.getNumber())>goodsMapper.queryGoodsCountByName(order.getGoodsname()))
            return 4;
        else {
            orderMapper.addOrder(order.getUsername(),order.getGoodsname(),order.getNumber(),order.getDate());
            int a=goodsMapper.queryGoodsCountByName(order.getGoodsname())-Integer.parseInt(order.getNumber());
            String number=String.valueOf(a);
            goodsMapper.alterGoodsCountByName(order.getGoodsname(),number);
            return 5;
        }
    }
}
