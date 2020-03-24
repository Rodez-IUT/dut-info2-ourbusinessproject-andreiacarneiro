package ourbusinessproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;


@Entity
public class Enterprise {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @Size (min = 10)
    private String description;

    @NotEmpty
    private String contactName;

    @NotEmpty @Email
    private String contactEmail;


    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public long getId() {
        return id;
    }

    public boolean addProject(Project project) {
        if (projects == null) {
            projects = new HashSet<>();
        }

        return projects.add(project);
    }

    public Collection<Project> getProjects() {
        return projects;
    }

}
