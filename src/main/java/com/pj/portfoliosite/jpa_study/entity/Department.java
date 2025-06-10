package com.pj.portfoliosite.jpa_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees =new ArrayList<>();

    @Override
    public String toString(){
        return "id: " + id + " name: " + name;
    }
}
