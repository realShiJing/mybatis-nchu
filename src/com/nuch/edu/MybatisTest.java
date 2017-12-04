package com.nuch.edu;

import java.io.IOException;
import java.io.InputStream;

import com.nuch.edu.domain.Employee;
import com.nuch.edu.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by yangshijing on 2017/12/4 0004.
 */
public class MybatisTest {


    public static void main(String[] args)throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

       // Employee employee = sqlSession.selectOne("com.nuch.edu.mapper.EmployeeMapper.selectOne", 1);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeByid(1);
        System.out.print(employee);


    }


}
