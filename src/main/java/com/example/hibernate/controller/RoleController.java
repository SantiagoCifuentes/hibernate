package com.example.hibernate.controller;

import com.example.hibernate.model.Project;
import com.example.hibernate.model.Role;
import com.example.hibernate.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    RoleService roleService;


    @GetMapping
    public List<Role> buscarProjectos() {
        return roleService.buscarRol();
    }

    @GetMapping(path="/role/{roleId}")
    public Optional<Role> obtenerProjectPorId(@PathVariable Long roleId) {
        return roleService.findById(roleId);
    }

    @PostMapping()
    public Role guardarRol(@RequestBody Role role)
    {
        return  this.roleService.registrarRol(role);

    }

    @DeleteMapping("/roleDelete/{id}")
    public String deleteProjectById(@PathVariable("id") Long id){
        boolean ok= this.roleService.deleteById(id);
        if(ok){
            return "Rol "+ id+ " eliminado";
        }else{
            return "Rol no eliminado";
        }
    }

    @PutMapping("/roleUpdate/{id}")
    public String updateRole(@PathVariable("id") Long id, @RequestBody Role role){
        return roleService.updateRole(id, role);
    }
}
