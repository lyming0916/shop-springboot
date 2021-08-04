package com.example.springboot.mapper;

import com.example.springboot.pojo.UserList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserListMapper {
    @Select("select * from userlist where username like #{query} limit #{num},#{size} ")
    List<UserList> queryUserList(String query, int num, int size);
    @Select("select * from userlist where username like #{username}")
    UserList queryUserByName(String username);
    @Select("select count(*) from userlist where username like #{query}")
    int queryUserCount(String query);
    @Insert("insert into userlist values (#{username},#{email},#{mobile},#{create_time},#{mg_state})")
    void addUser(String username, String email, String mobile, @Param("create_time") String date,@Param("mg_state") boolean state);
    @Delete("delete from userlist where username like #{username}")
    void deleteUser(String username);
    @Update("update userlist set email=#{email},mobile=#{mobile} where username like #{username}")
    void alterUser(String username,String email,String mobile);
    @Update("update userlist set mg_state=#{mg_state} where username like #{username}")
    void changeState(String username,@Param("mg_state") boolean state);
}
