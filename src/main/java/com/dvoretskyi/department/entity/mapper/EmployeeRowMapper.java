package com.dvoretskyi.department.entity.mapper;

import com.dvoretskyi.department.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
    // try {
    Employee employee = new Employee();
    // Department department = new Department();
//return row.getString(1);
    employee.setId(row.getLong("employee_id"));
    employee.setName(row.getString("employee_name"));
    employee.setActive(row.getBoolean(1));
    //department.setId(row.getLong();
    return employee;


  /*
In JdbcTemplate , queryForInt, queryForLong, queryForObject all such methods expects that executed query will return one and only one row. If you get no rows or more than one row that will result in IncorrectResultSizeDataAccessException . Now the correct way is not to catch this exception or EmptyResultDataAccessException, but make sure the query you are using should return only one row. If at all it is not possible then use query method instead.

List<String> strLst  = getJdbcTemplate().query(sql,new RowMapper {

  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
  }

});

if ( strLst.isEmpty() ){
  return null;
}else if ( strLst.size() == 1 ) { // list contains exactly 1 element
  return strLst.get(0);
}else{  // list contains more than 1 elements
  //your wish, you can either throw the exception or return 1st element.
}*/
  /*} catch (final EmptyResultDataAccessException e) {
    return null; }}*/
 // }
}}
