package ourbusinessproject;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;


    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    public Project() {
    }

    public Project(@NotEmpty String title, String description, @NotNull Enterprise enterprise) {
        this.title = title;
        this.description = description;
        setEnterprise(enterprise);
    }

    public String getTitle() {
        return title;
    }

    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setEnterprise(Enterprise enterprise) {
        if (this.enterprise != null) {
            this.enterprise.getProjects().remove(this);
        }
        this.enterprise = enterprise;
        if (this.enterprise != null) {
            if (this.enterprise.getProjects() == null) {
                this.enterprise.setProjects(new ArrayList<>());
            }
            this.enterprise.getProjects().add(this);
        }
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }


}
