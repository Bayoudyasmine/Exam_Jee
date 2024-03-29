package DAO;

import DAO.ProjectDao;
import Modele.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.eclipse.persistence.sessions.Project;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Project> findAll() {
        Query query = em.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }

    @Override
    public Project findById(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    public void save(Project project) {
        if (project.getName() == null) {
            em.persist(project);
        } else {
            em.merge(project);
        }
    }

    @Override
    public void delete(Project project) {
        em.remove(em.contains(project) ? project : em.merge(project));
    }

    @Override
    public List<Employee> getEmployeesByProjectId(Long projectId) {
        return null;
    }

    @Override
    public void assignProjectToEmployee(Long projectId, Long employeeId) {

    }

    @Override
    public void unassignProjectFromEmployee(Long projectId, Long employeeId) {

    }

}
