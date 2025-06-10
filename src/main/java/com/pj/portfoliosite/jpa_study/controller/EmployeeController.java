package com.pj.portfoliosite.jpa_study.controller;

import com.pj.portfoliosite.jpa_study.entity.Employee;
import com.pj.portfoliosite.jpa_study.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping("/department/{departmentId}/employee")
    public HttpEntity<String> employeeAdd(@RequestBody Employee employee, @PathVariable Long departmentId){
        employeeService.addDepartment(employee,departmentId);
        System.out.println("이름 정보"+employee.getName());
        return new HttpEntity<>("ok");
    }
    //Department 로 사원들 구하기
    @GetMapping("/department/{departmentId}/employee")
    public HttpEntity<List<Employee>> employeeGets(@PathVariable Long departmentId){
        List<Employee> employees = employeeService.findByDepartment(departmentId);
        return new HttpEntity<>(employees);
    }
    //사원으로 부서 변경하기
    @PatchMapping("/department/{departmentId}/employee/{employeeId}")
    public HttpEntity<String> employeeChangeDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId){
        employeeService.updateDepartment(departmentId,employeeId);
        return new HttpEntity<>("ok");
    }
    //사원 삭제
    @DeleteMapping("/employee/{id}")
    public HttpEntity<String> employeeDelete(@PathVariable Long id){
        employeeService.removeEmployee(id);
        return new HttpEntity<>("ok");
    }
    @DeleteMapping("/department/{departmentId}/employee")
    public HttpEntity<String> deleteAll (@PathVariable Long departmentId){
        employeeService.deleteAll(departmentId);
        return new HttpEntity<>("ok");
    }
}
