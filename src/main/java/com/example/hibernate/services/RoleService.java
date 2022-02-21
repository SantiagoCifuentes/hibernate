package com.example.hibernate.services;

import com.example.hibernate.model.Project;
import com.example.hibernate.model.Role;
import com.example.hibernate.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService
{
    @Autowired
    RoleRepository roleRepo;

    public List<Role> buscarRol(){
        return roleRepo.findAll();
    }

    public Optional<Role> findById(Long id){
        return roleRepo.findById(id);
    }

    public Role registrarRol(Role role){
        return roleRepo.save(role);
    }

    public Role findByName(String name){
        return roleRepo.findByName(name);
    }

    public boolean deleteById(Long id){
        try {
            roleRepo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public String updateRole(long id, Role role) {
        Optional<Role> roleData = roleRepo.findById(id);

        if (roleData.isPresent()) {
            Role role1 = roleData.get();
            role1.setName(role1.getName());


            roleRepo.save(role1);
            return "Rol actualizado";
        } else {
            return "No se pudo actualizar";
        }
}
}
