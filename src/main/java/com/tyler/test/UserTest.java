package com.tyler.test;

import com.tyler.mapper.UserMapper;
import com.tyler.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by tyler on 2016/12/6.
 * 测试方法
 */
public class UserTest {
    SqlSession sqlSession = null;
   @Test
    public void query(){
       try {
           //通过SqlSessionFactory创建SqlSession
           sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
           //通过SqlSession获取映射器Mapper
           UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
           //调用UserMapper.java接口中的方法，此方法自动转到UserMapper.xml中找到对应方法去执行
           User user = userMapper.getName(1);
           //输出结果
           System.out.println(user.getName());
           //提交事务
           sqlSession.commit();
       } catch (Exception e) {
           e.printStackTrace();
           //出现异常，回滚事务
           sqlSession.rollback();
       } finally {
           //若SqlSession不为空，关闭若SqlSession不为空
           if(sqlSession!=null){
               sqlSession.close();
           }
       }
   }

}
