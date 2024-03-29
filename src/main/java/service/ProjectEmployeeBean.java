package service;

import DAO.EmployeeDao;
import DAO.ProjectDao;
import Modele.Employee;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.persistence.sessions.Project;
import java.util.List;

@Named
@SessionScoped
public class ProjectEmployeeBean {

    @Inject
    private ProjectDao projectDao;

    @Inject
    private EmployeeDao employeeDao;

    private List<Project> projects;

    private Employee selectedEmployee;

    public void init() {
        projects = projectDao.findAll();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Employee> getAvailableEmployees() {
        return employeeDao.findAll();
    }

    public void setEmployeeDao(Object employeeDao) {
    }

    public void setProjectDao(Object projectDao) {

    }
}
