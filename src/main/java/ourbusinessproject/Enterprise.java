package ourbusinessproject;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Enterprise {


    private long id;

    @NotEmpty
    private String name;

    @Size (min = 10)
    private String description;

    @NotEmpty
    private String contactName;

    @NotEmpty @Email
    private String contactEmail;

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
}
