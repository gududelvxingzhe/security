package com.jettech.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.jettech.cache.bean.Department;

@Mapper
public interface DepartmentMapper {

	@Select("select * from department where id = #{id}")
	public Department getById(Integer id);
}
