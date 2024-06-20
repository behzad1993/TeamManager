package one.behzad.teammanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "team")
public class Team extends BaseEntity {

    private String name;
    private String sports;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "teams")
    @JsonIgnore
    @ToString.Exclude
    private List<Member> members;

//    @OneToOne
//    private ImageDB profilePicture;

//    @Override
//    public String toString() {
//        return "NOTHING TO SEE HERE FOR THE TEAM";
//    }
}
