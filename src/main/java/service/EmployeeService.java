package service;

import DAO.EmployeeDao;
import Modele.Employee;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EmployeeService implements Serializable {

    @Inject
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    public Employee addEmployee(String name, String email, List<String> skills) {
        Employee employee = new Employee(name, email, skills);
        employeeDao.save(employee);
        return employee;
    }

    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeDao.findById(id);
        employeeDao.delete(employee);
    }

}
