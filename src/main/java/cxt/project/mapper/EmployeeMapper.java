package cxt.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cxt.project.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
