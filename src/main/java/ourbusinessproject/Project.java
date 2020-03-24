package ourbusinessproject;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue
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
        this.enterprise = enterprise;
        this.description = description;
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
        this.enterprise = enterprise;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }


}
