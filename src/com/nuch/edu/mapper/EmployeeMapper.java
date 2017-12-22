package com.nuch.edu.mapper;

import com.nuch.edu.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yangshijing on 2017/12/4 0004.
 */
public interface EmployeeMapper {

    public Employee getEmployeeByid(Integer id);

    public void updateEmp(Employee employee);

    public  void deleteEmp(Integer id);

    public void addEmp(Employee employee);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);

    public  Employee getEmpByMap(Map<String,Object> map);

    public Map<String,Object> getEmpReturnMap(String lastName);

    public List<Employee> getEmpReturnList(String lastName);

    /**
     * 返回多条记录
     * @param lastName
     * @return
     */
    @MapKey("lastName")
    public Map<String,Employee> getEmpReturnMap1(String lastName);

    /**
     * 多表联合查询
     *
     */
    public Employee getEmpAndDep(Integer id);

    public  Employee getEmpByStep(Integer id);

    public List<Employee> getEmpByDepId(Integer id);
}
