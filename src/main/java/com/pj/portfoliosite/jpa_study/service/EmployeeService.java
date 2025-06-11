package com.pj.portfoliosite.jpa_study.service;

import com.pj.portfoliosite.jpa_study.entity.Department;
import com.pj.portfoliosite.jpa_study.entity.Employee;
import com.pj.portfoliosite.jpa_study.repository.DepartmentRepository;
import com.pj.portfoliosite.jpa_study.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    //사원추가 및  부서에 추가하기
    public void addDepartment(Employee employee, Long departmentId) {

        Department department = departmentRepository.findById(departmentId);
        employee.setDepartment(department);
        employeeRepository.addDepartment(employee);
    }
    // 부서안에 모든 사원들 가져오기
    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }
    //사원 부서 이동
    public void updateDepartment(Long departmentId, Long employeeId) {
        Employee employee = employeeRepository.findByEmployee(employeeId);
        Department department = departmentRepository.findById(departmentId);
        employee.setDepartment(department);
        employeeRepository.update(employee);
    }
    //사원 삭제
    public void removeEmployee(Long id) {
        employeeRepository.remove(id);
    }
    // 부서의 있는 사원들 삭제
    public void deleteAll(Long departmentId) {
        employeeRepository.removeAll(departmentId);
    }
    // 부서에 있는 사원들 조회
    public List<Employee> findByDepartmentEmployees(Long departmentId) {
        return employeeRepository.findByDepartmentEmployees(departmentId);

    }
}
