package com.pj.portfoliosite.jpa_study.repository;

import com.pj.portfoliosite.jpa_study.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRe extends JpaRepository<Department, Long> {

}
