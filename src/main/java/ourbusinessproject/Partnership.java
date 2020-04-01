package ourbusinessproject;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Partnership {

    private Long id;

    @NotNull
    private Date creationDate;

    @NotNull
    private Enterprise enterprise;

    @NotNull
    private Project project;


    public Partnership(long id) {
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
