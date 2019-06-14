package com.example.redis.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redis.bean.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>
{

}
