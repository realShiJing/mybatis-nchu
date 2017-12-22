package com.nuch.edu;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.nuch.edu.domain.Department;
import com.nuch.edu.domain.Employee;
import com.nuch.edu.mapper.DepartmentMapper;
import com.nuch.edu.mapper.EmployeeDynamicSql;
import com.nuch.edu.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.compiler.SymbolTable;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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

    /**
     * 测试增删改
     * 增删改要提交
     */
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //String email, String gender, int id, String lastName
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
       try {
           //测试添加
           //Employee employee = new Employee("tom@nchu.com", "0", null, "tom");
          // mapper.addEmp(employee);
           //System.out.print(employee.getId());

           //测试删除
           //mapper.deleteEmp(2);

           //测试更改
           //Employee employee = new Employee("jerry@nchu.com","0",3,"jerry");
          // mapper.updateEmp(employee);

           //测试参数
           //Employee jerry = mapper.getEmpByIdAndLastName(3, "jerry");

           //测试Map
         /*  Map<String,Object> map = new HashMap<>();
           map.put("id",3);
           map.put("lastName","jerry");
           Employee jerry = mapper.getEmpByMap(map);
           System.out.print(jerry);*/

           //测试返回map类型
          /* Map<String, Object> map = mapper.getEmpReturnMap("jerry");
           System.out.print(map);*/

           //测试返回List
          /* List<Employee> list = mapper.getEmpReturnList("%t%");
           System.out.print(list);*/

           //测试返回多条map记录
         /*  Map<String,Employee> map = mapper.getEmpReturnMap1("%t%");
           System.out.print(map);*/

           //测试多表查询
         /*  Employee empAndDep = mapper.getEmpAndDep(1);
           System.out.print(empAndDep);*/

           //测试分步查询
           /*Department depById = deptMapper.getDepById(1);
           System.out.print(depById);*/
          /* Employee empByStep = mapper.getEmpByStep(1);
           System.out.println(empByStep.getLastName());
           System.out.println(empByStep.getDept());*/

           //测试集合属性
         /*  Department depCollection = deptMapper.getDepCollection(1);
           System.out.println(depCollection);
           System.out.println(depCollection.getEmps());
*/
           //测试集合分步查询
           Department depByStep = deptMapper.getDepByStep(1);
           System.out.println(depByStep);
           System.out.print(depByStep.getEmps());
         /*  List<Employee> emps = mapper.getEmpByDepId(1);
           System.out.print(emps);*/
           sqlSession.commit();
       }finally {
           sqlSession.close();
       }
    }

    /**
     * 测试动态Sql
     *
     */
    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeDynamicSql employeeDynamicSql = sqlSession.getMapper(EmployeeDynamicSql.class);

        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            Employee employee = new Employee("","",1,"234ffs");
//            List<Employee> empsByConditionIf = employeeDynamicSql.getEmpsByConditionIf(employee);
//            System.out.print(empsByConditionIf);
//            List<Employee> empsByConditionTrim = employeeDynamicSql.getEmpsByConditionTrim(employee);
//            System.out.print(empsByConditionTrim);
//            List<Employee> empsByConditionChoose = employeeDynamicSql.getEmpsByConditionChoose(null);
//            System.out.print(empsByConditionChoose);
//            employeeDynamicSql.UpdateEmpsBySet(employee);
//            List<Employee> empsByConditionCollection = employeeDynamicSql.getEmpsByConditionCollection(Arrays.asList(1, 2, 3, 4));
//            System.out.print(empsByConditionCollection);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee("xiaoming@nchu.com","1",null,"xiaoming"));
            emps.add(new Employee("daxiong@nchu.com","1",null,"daxiong"));
            emps.add(new Employee("xiewentao@nchu.com","1",null,"xiewentao"));
            emps.add(new Employee("shijing@nchu.com","1",null,"shijing"));

            employeeDynamicSql.addEmps(emps);
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }


}
