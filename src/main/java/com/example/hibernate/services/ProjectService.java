package com.example.hibernate.services;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Project;
import com.example.hibernate.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepo;

    public List<Project> buscarProjectos() {
        return projectRepo.findAll();
    }


    public Optional<Project> findById(Long id) { //buscar proyecto por id
        return projectRepo.findById(id);
    }

    public Project findByName(String name) { //buscar proyecto por nombre
        return projectRepo.findByName(name);
    }

    public Project guardarProjecto(Project project) {
        return projectRepo.save(project);//registro de usuarios
    }

    public boolean deleteById(Long id) {
        try {
            projectRepo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }


    }

    public String updateProject(long id, Project project) {
        Optional<Project> projectData = projectRepo.findById(id);

        if (projectData.isPresent()) {
            Project project1 = projectData.get();
            project1.setName(project1.getName());


            projectRepo.save(project1);
            return "Proyecto actualizado";
        } else {
            return "No se pudo actualizar";
        }
}
}
