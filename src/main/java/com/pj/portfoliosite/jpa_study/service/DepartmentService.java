package com.pj.portfoliosite.jpa_study.service;

import com.pj.portfoliosite.jpa_study.entity.Department;
import com.pj.portfoliosite.jpa_study.repository.DepartmentRe;
import com.pj.portfoliosite.jpa_study.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRe departmentRe;
    private final DepartmentRepository departmentRepository;

    //조회
    public List<Department> findAll() {
        return departmentRe.findAll();
    }
    // 저장
    public void save(Department department) {
         departmentRe.save(department);
    }
    // 삭제
    public void delete(Department department) {
        departmentRe.delete(department);
    }
    // id로 조회
    public Department findById(Long id) {
        return departmentRe.findById(id).orElse(null);
    }
    // 수정
    @Transactional
    public void updateDepartment(Long id, Department department) {
        Department dept = departmentRe.findById(id).orElse(null);
        System.out.println(department.getName().toString());
        dept.setName(department.getName());
    }

    // 전체 조회
    public List<Department> emFindAll(){
        return departmentRepository.findByAll();
    }
    //
    public Department emfFndById(Long id){
        return departmentRepository.findById(id);
    }
    public void emfSave(Department department) {
        departmentRepository.save(department);
    }
    public void emfDelete(Department department) {
        departmentRepository.delete(department);
    }
    public void emUpdate(Long id, Department department) {
        departmentRepository.updateDepartment(id, department);
    }
}
