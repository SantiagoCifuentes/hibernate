package com.example.hibernate.controller;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Project;
import com.example.hibernate.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController
{

    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> buscarProjectos() {
        return projectService.buscarProjectos();
    }

    @GetMapping(path="/project/{proyectId}")
    public Optional<Project> obtenerProjectPorId(@PathVariable Long employeeId) {
        return projectService.findById(employeeId);
    }

    @PostMapping()
    public Project guardarProjecto(@RequestBody Project project)
    {
        return  this.projectService.guardarProjecto(project);
    }

    @DeleteMapping("/projectDelete/{id}")
    public String deleteProjectById(@PathVariable("id") Long id){
        boolean ok= this.projectService.deleteById(id);
        if(ok){
            return "Proyecto "+ id+ " eliminado";
        }else{
            return "Proyecto no eliminado";
        }
    }

    @PutMapping("/projectUpdate/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }




}
