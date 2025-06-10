package com.pj.portfoliosite.jpa_study.repository;

import com.pj.portfoliosite.jpa_study.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em;
    public void addDepartment(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return
        em.createQuery("SELECT e FROM Employee  e where e.department.id =: departmentId ")
                .setParameter("departmentId",departmentId)
                .getResultList();

    }

    public Employee findByEmployee(Long employeeId) {
        return em.find(Employee.class, employeeId);
    }

    public void update(Employee employee) {
        em.merge(employee);
    }

    public void remove(Long id) {
        em.remove(em.find(Employee.class, id));
    }

    public void removeAll(Long departmentId) {

    }
}
