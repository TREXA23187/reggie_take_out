package cxt.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cxt.project.common.Result;
import cxt.project.entity.Employee;
import cxt.project.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController  {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee){

        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());

        Employee emp = employeeService.getOne(queryWrapper);

        if(emp==null){
            return Result.error("failed to login");
        }

        if(!emp.getPassword().equals(password)){
            return Result.error("failed to login");
        }

        if (emp.getStatus() == 0) {
            return Result.error("failed to login");
        }

        request.getSession().setAttribute("employee",emp.getId());
        return Result.success(emp);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return Result.success("logout!");
    }
}
