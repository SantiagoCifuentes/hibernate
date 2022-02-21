package com.example.hibernate.controller;

import com.example.hibernate.model.Employee;
import com.example.hibernate.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> buscarEmployees() {
        return employeeService.buscarEmpleado();
    }

    @GetMapping(path="/employee/{employeeId}")
    public Optional<Employee> obtenerEmployeePorId(@PathVariable ("employeeId")  Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping()
    public Employee guardarEmpleado(@RequestBody Employee employee)
    {
        return  this.employeeService.guardarEmpleado(employee);
    }




    @DeleteMapping("/employeeDelete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        boolean ok= this.employeeService.deleteEmpleado(id);
        if(ok){
            return "Empleado "+ id+ " eliminado";
        }else{
            return "Empleado no eliminado";
        }
    }

    @PutMapping("/employeeUpdate/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }


}
