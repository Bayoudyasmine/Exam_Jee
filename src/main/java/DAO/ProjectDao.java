package DAO;

import Modele.Employee;
import org.eclipse.persistence.sessions.Project;

import java.util.List;

public interface ProjectDao {
    Project findById(Long id);

    List<Project> findAll();

    void save(Project project);

    void delete(Project project);

    List<Employee> getEmployeesByProjectId(Long projectId);

    void assignProjectToEmployee(Long projectId, Long employeeId);

    void unassignProjectFromEmployee(Long projectId, Long employeeId);
}

