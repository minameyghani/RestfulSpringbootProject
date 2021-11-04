package ir.maktab.springrestproject.service;


import ir.maktab.springrestproject.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getById(Integer id);
    Employee updateEmployee(Employee e, Integer id);
    void deleteEmployee(Integer id);
}
