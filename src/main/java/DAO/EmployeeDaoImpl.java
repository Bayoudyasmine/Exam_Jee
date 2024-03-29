package DAO;

import DAO.EmployeeDao;
import Modele.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.eclipse.persistence.sessions.Project;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findAll() {
        Query query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        if (null != employee.getId()) {
            em.merge(employee);
        } else {
            em.persist(employee);
        }
    }

    @Override
    public void delete(Employee employee) {
        em.remove(em.contains(employee) ? employee : em.merge(employee));
    }

    @Override
    public List<Project> getProjectsByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public void assignEmployeeToProject(Long employeeId, Long projectId) {

    }

    @Override
    public void unassignEmployeeFromProject(Long employeeId, Long projectId) {

    }

    @Override
    public void update(Employee employee) {

    }

}
