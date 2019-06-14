package com.example.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.redis.bean.Employee;
import com.example.redis.data.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableCaching
@Slf4j
public class RedisApplication implements CommandLineRunner
{

    private EmployeeRepository employeeRepository;

    @Autowired
    public RedisApplication (EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public static void main (String[] args)
    {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("i334499", "Apple", 2000L));
        employees.add(new Employee("i334490", "Orange", 3000L));
        employees.add(new Employee("i334491", "Amber", 4000L));
        employees.add(new Employee("i334492", "White", 5000L));
        employees.add(new Employee("i334493", "Red", 10000L));

        employees.forEach(employee -> {
            log.info("Saving the User {}", employee.getId());
            employeeRepository.save(employee);
        });
        log.info("Saved All Employeers ::{}",employeeRepository.findAll());
    }

}
