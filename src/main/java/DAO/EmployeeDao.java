package DAO;

import Modele.Employee;
import org.eclipse.persistence.sessions.Project;

import java.util.List;

public interface EmployeeDao {
    Employee findById(Long id);

    List<Employee> findAll();

    void save(Employee employee);

    void delete(Employee employee);

    List<Project> getProjectsByEmployeeId(Long employeeId);

    void assignEmployeeToProject(Long employeeId, Long projectId);

    void unassignEmployeeFromProject(Long employeeId, Long projectId);

    void update(Employee employee);
}


