package com.example.hibernate.repository;

import com.example.hibernate.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long>
{
    Project findByName(String name);
}
