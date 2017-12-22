package com.nuch.edu.mapper;

import com.nuch.edu.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangshijing on 2017/12/20 0020.
 */
public interface EmployeeDynamicSql {

    public List<Employee>  getEmpsByConditionIf(Employee employee);

    public List<Employee>  getEmpsByConditionTrim(Employee employee);

    public List<Employee>  getEmpsByConditionChoose(Employee employee);

    public void  UpdateEmpsBySet(Employee employee);

    public List<Employee>  getEmpsByConditionCollection(@Param("ids") List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> emps);
 }
