package Modele;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @Column(name = "skills")
    private List<String> skills;

    // constructors, getters, and setters

    public Employee() {}

    public Employee(String name, String email, List<String> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    // equals and hashCode methods

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Object getId() {
    }
}
