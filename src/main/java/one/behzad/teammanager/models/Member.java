package one.behzad.teammanager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    // TODO: different Team, different role. Needs to be considered

    private String surName;
    private String lastName;
    private String email;
    private String phoneNr;
    private Date birthday;

//    @OneToOne
//    private ImageDB profilePicture;
//
//    @OneToMany
//    private Map<Team, RoleTypes> rolesPerTeam;

    //    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "member_team",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"))
    private Set<Team> teamSet;

//    private Date joinDate;
//    private Date leaveDate;
//    private String street;
//    private String houseNr;
//    private String zipCode;
//    private String City;
//    private String State;
//    private String country;
}
