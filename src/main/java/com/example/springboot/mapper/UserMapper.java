package com.example.springboot.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select password from user where name like #{name}")
    String login(String id);
}
