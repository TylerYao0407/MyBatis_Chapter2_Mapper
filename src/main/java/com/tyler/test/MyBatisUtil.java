package com.tyler.test;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;

/**
 * Created by tyler on 2016/12/6.
 * 得到SqlSessionFactory
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream inputStream = null;
        if(sqlSessionFactory == null){
            try {
                //获得MyBatis的配置文件
                String resource = "mybatis-config.xml";
                //将配置信息装入到输入流中
                inputStream = Resources.getResourceAsStream(resource);
                //通过SqlSessionFactoryBuilder构建SqlSessionFactory
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                return sqlSessionFactory;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
