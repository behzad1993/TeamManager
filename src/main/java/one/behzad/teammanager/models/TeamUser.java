package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TeamUser extends BaseEntity {

    private Role role;

    // TODO: different Team, different role. Needs to be considered
    @OneToMany
    private List<Team> team;
    private String surName;
    private String lastName;
    private String email;
    private String phoneNr;
    private Date birthday;
    private Date joinDate;
    private Date leaveDate;

    @OneToOne
    private FileDB profilePicture;

    private String street;
    private String houseNr;
    private String zipCode;
    private String City;
    private String State;
    private String country;

    public TeamUser() {

    }
}
