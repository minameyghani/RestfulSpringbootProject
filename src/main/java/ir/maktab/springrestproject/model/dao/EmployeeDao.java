package ir.maktab.springrestproject.model.dao;


import ir.maktab.springrestproject.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
