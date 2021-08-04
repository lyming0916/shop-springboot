package com.example.springboot.controller;

import com.example.springboot.mapper.UserListMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.User;
import com.example.springboot.pojo.UserList;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
public class Controller {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserListMapper userListMapper;

    @RequestMapping("/login")
    public int login(User user) {
        String password=userMapper.login(user.getId());
        if(password==null)
            return 2;
        if(password.equals(user.getPassword()))
            return 1;
        else
            return 2;
    }
    @RequestMapping("getUserList")
    public List<UserList> list(String query, @RequestParam("pagenum") int num, @RequestParam("pagesize")int size){
        num=(num-1)*size;
        if(query.equals(""))
            query="%";
        return userListMapper.queryUserList(query,num,size);
    }
    @RequestMapping("userCount")
    public int UserCount(String query){
        if(query.equals(""))
            query="%";
        return userListMapper.queryUserCount(query);
    }
    @RequestMapping("addUser")
    public void addUSer(String username,String email,String mobile,String date){
        System.out.println(date);
        userListMapper.addUser(username,email,mobile,date, false);
    }
    @RequestMapping("deleteUser")
    public void deleteUSer(String username){
        userListMapper.deleteUser(username);
    }
    @RequestMapping("alterUser")
    public void alterUSer(String username,String email,String mobile){
        userListMapper.alterUser(username,email,mobile);
    }
    @RequestMapping("changeState")
    public void alterUSer(String username,boolean state){
        userListMapper.changeState(username,state);
    }
}
