package cxt.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cxt.project.entity.Employee;
import cxt.project.mapper.EmployeeMapper;
import cxt.project.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
