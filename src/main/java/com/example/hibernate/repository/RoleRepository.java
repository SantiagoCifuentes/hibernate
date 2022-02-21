package com.example.hibernate.repository;
import com.example.hibernate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

public interface RoleRepository extends JpaRepository<Role,Long>
{
    Role findByName(String name);
}
