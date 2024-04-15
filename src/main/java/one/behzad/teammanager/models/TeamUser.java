package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.File;
import java.util.UUID;

@Entity
//@Table(name = "team_user")
@Data
public class TeamUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

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
