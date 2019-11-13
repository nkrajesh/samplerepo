package com.raj.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.model.Employee;
import com.raj.service.EmployeeService;
 
@RestController
public class EmployeeController {
 
    @Autowired
    EmployeeService serv;
 
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @RequestMapping(value= "create",method = RequestMethod.POST,consumes = { MediaType.APPLICATION_JSON_VALUE})
    public String create(@RequestBody Employee emp) {
        logger.debug("Saving employees.");
        serv.createEmployee(emp);
        return "Employee records created.";
    }
 
    @GetMapping(value= "/getall")
    public Collection<Employee> getAll() {
        logger.debug("Getting all employees.");
        return serv.getAllEmployees();
    }
 
    @GetMapping(value= "/getbyid/{employee-id}")
    public ResponseEntity<Employee> getById(@PathVariable(value= "employee-id") int id) {
        logger.debug("Getting employee with employee-id= {}.", id);
        return 	serv.findEmployeeById(id)
        		.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());        
    }
 
    @PutMapping(value= "/update/{employee-id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee e) {
        logger.debug("Updating employee with employee-id= {}.", id);
        e.setId(id);
        serv.updateEmployee(e);
        return "Employee record for employee-id= " + id + " updated.";
    }
 

    @DeleteMapping(value= "/delete/{employee-id}")
    public String delete(@PathVariable(value= "employee-id") int id) {
        logger.debug("Deleting employee with employee-id= {}.", id);
        serv.deleteEmployeeById(id);
        return "Employee record for employee-id= " + id + " deleted.";
    }
 
}