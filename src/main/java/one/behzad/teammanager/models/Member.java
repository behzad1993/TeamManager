package one.behzad.teammanager.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
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
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    private Set<Team> teams;

    public Member(long i, String a, String b) {
        this.id = i;
        this.surName = a;
        this.lastName = b;
    }

    public Member(String a, String b) {
        this.surName = a;
        this.lastName = b;
    }

//    private Date joinDate;
//    private Date leaveDate;
//    private String street;
//    private String houseNr;
//    private String zipCode;
//    private String City;
//    private String State;
//    private String country;
}
