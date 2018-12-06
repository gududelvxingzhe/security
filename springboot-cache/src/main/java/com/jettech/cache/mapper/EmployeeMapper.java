package com.jettech.cache.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jettech.cache.bean.Employee;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee where id = #{id}")
	public Employee getEmployee(Integer id);
	
	
	@Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender},d_id = #{dId} where id = #{id}")
	public void updateEmp(Employee employee);
	
	@Delete("delete from employee where id = #{id}")
	public void deleteEmpById(Integer id);
	
	@Insert("insert into employee(lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
	public void insertEmp(Employee employee);
	
    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
