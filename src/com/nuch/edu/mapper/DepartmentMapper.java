package com.nuch.edu.mapper;

import com.nuch.edu.domain.Department;

/**
 * Created by yangshijing on 2017/12/19 0019.
 */
public interface  DepartmentMapper {
    public Department getDepById(Integer id);

    public Department getDepCollection(Integer id);

    public Department getDepByStep(Integer id);
}
