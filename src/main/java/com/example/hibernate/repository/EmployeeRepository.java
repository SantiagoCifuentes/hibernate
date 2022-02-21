package com.example.hibernate.repository;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    Employee findByEmployeeid(String employeeid);
    List<Employee>findByLastName(String lastName);
    List<Employee> findByRole(Role role);



}
