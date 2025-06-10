package com.pj.portfoliosite.jpa_study.repository;

import com.pj.portfoliosite.jpa_study.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DepartmentRepository{
    @PersistenceContext
    private EntityManager em;
    // 저장하는  메소드
    public void save(Department department) {
        em.persist(department);
    }
    //단일 조회
    public Department findById(Long id) {
        return em.find(Department.class, id);
    }

    // 삭제
    public void delete(Department department) {
        em.remove(department);
    }
    // update
    public void updateDepartment(Long id,Department department) {
        em.createQuery("UPDATE Department d SET d.name = :name WHERE d.id = :id")
                .setParameter("name", department.getName())
                .setParameter("id", id);
    }
    // 전체 조회
    public List<Department> findByAll() {
        return em.createQuery("select d from Department d", Department.class).getResultList();
    }
}
