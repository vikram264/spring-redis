package com.example.redis.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String employeeId;
    private String name;
    private Long salary;

    public Employee ()
    {
       
    }

    public Employee (String id, String name, Long salary)
    {
        super();
        this.employeeId = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId ()
    {
        return employeeId;
    }

    public void setId (String id)
    {
        this.employeeId = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Long getSalary ()
    {
        return salary;
    }

    public void setSalary (Long salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString ()
    {
        return "Employee [id=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
    }

}
