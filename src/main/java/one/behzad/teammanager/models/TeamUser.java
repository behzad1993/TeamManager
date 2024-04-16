package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TeamUser extends BaseEntity {

    private String surName;
    private String lastName;
    private String email;
    private String phoneNr;

    private File profilePicture;

    private String street;
    private String houseNr;
    private String zipCode;
    private String City;
    private String State;
    private String country;

    public TeamUser() {

    }
}
