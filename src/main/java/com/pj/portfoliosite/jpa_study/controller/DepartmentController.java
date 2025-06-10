package com.pj.portfoliosite.jpa_study.controller;

import com.pj.portfoliosite.jpa_study.dto.MemberDTO;
import com.pj.portfoliosite.jpa_study.entity.Department;
import com.pj.portfoliosite.jpa_study.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping("/member/add")
    public HttpEntity<String> addMember(@RequestBody MemberDTO memberDTO) {
        return new HttpEntity<>("ok");
    }
    @PostMapping("/department/add")
    public HttpEntity<String> addDepartment(@RequestBody Department department){
        departmentService.save(department);
        return new HttpEntity<>("ok");
    }
    @GetMapping("/department/{id}")
    public HttpEntity<String> updateDepartment(@PathVariable Long id){
      Department department =   departmentService.findById(id);
      return new HttpEntity<>(department.getName());
    }
    @GetMapping("/departments")
    public HttpEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentService.findAll();
        return new HttpEntity<>(departments);
    }
    @PatchMapping("/update/department/{id}")
    public HttpEntity<String> updateDepartment(@RequestBody Department department,@PathVariable  Long id){
        departmentService.updateDepartment(id,department);
        return new HttpEntity<>("ok");
    }

}
