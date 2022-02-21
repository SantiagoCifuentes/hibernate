package com.example.hibernate.services;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Role;
import com.example.hibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repoEmplado;


    public List<Employee> buscarEmpleado() {
        return repoEmplado.findAll();
    }

    public Optional<Employee> findById(Long id) { //buscar proyecto por id
        return repoEmplado.findById(id);

    }

    public List<Employee> findByLastname(String lastName) { //buscar empleado por apellido
        return repoEmplado.findByLastName(lastName);
    }

    public List<Employee> findByRole(Role role) { //buscar empleado por rol
        return repoEmplado.findByRole(role);
    }


    public Employee guardarEmpleado(Employee employee) {
        return repoEmplado.save(employee);//registro de empleado
    }


    public String updateEmployee(long id, Employee employee) {
        Optional<Employee> employeeData = repoEmplado.findById(id);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setFirstName(employee.getFirstName());
            _employee.setLastName(employee.getLastName());
            _employee.setRole(employee.getRole());
            _employee.setEmployeeid(employee.getEmployeeid());
            repoEmplado.save(_employee);
            return "Empleadoo actualizado";
        } else {
            return "Empleado no actualizado";
        }


    }

    public Boolean deleteEmpleado(Long id) {
        try {
            repoEmplado.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }


    }
}






