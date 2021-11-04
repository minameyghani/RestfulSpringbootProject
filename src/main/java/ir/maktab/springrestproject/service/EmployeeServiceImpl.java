package ir.maktab.springrestproject.service;

import ir.maktab.springrestproject.exception.ResourceNotFoundException;
import ir.maktab.springrestproject.model.dao.EmployeeDao;
import ir.maktab.springrestproject.model.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Employee","id",id));
    }

    @Override
    public Employee updateEmployee(Employee e, Integer id) {

        Employee existingEmployee = employeeDao.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id", id));
        existingEmployee.setName(e.getName());
        existingEmployee.setFamily(e.getFamily());
        existingEmployee.setEmail(e.getEmail());
        employeeDao.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        employeeDao.deleteById(id);
    }
}
