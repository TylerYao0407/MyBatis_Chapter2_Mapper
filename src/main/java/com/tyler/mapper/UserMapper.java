package com.tyler.mapper;

import com.tyler.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tyler on 2016/12/6.
 */
public interface UserMapper {
    /*
        注解实现
    @Select(value = "select * from user where id=#{id}")
    */
    //这个方法和UserMapper.xml中的方法一一对应，这个方法名对应xml文档中的id
    public User getName(int id);
}
