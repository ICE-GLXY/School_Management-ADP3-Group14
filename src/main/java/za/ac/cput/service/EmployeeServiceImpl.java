package za.ac.cput.service;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 14 June 2022
School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.util.Helper;

import java.util.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;

   @Autowired
   public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String employeeId) {
        return this.repository.findById(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

    @Override
    public List<Employee> readAll() {
        return this.repository.findAll();

    }

    //Question 5
    @Override
    public Optional<Employee> findEmployeeByEmail(String email) {
        Helper.isValidEmail(email);
        return repository.findEmployeeByEmail(email);
    }

    //Question 6
    @Override
    public List<Employee> getEmployeesByCity(String cityId) {
        List<Employee> employeeList = readAll().stream().filter(x -> x.getCity().getId() == cityId).toList();

        return  employeeList;
    }

}
