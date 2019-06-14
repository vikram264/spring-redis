package com.example.redis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.bean.Employee;
import com.example.redis.data.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController
{
  
    private EmployeeRepository employeeRepository;
    
    
    @Autowired
    public  EmployeeController (EmployeeRepository employeeRepository)
    
    {
        this.employeeRepository=employeeRepository;
    }

    @Cacheable(value = "employees",key = "#id", unless = "#result.salary < 5000")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployee (@PathVariable String id)
    {

        log.info("A get call for {}", id);
        return employeeRepository.findById(id);
    }

    @CachePut(value = "employee", key = "#employee.id")
    @PutMapping("/update")
    public Employee updateEmployeeById (@RequestBody Employee employee)
    {
        employeeRepository.save(employee);
        return employee;
    }
    
    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{id}")
    public void deleteEmployeeByID(@PathVariable String id) {
      log.info("Deleting Employee with id {}", id);
      employeeRepository.deleteById(id);
    }

}
