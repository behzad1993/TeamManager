package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
class Team extends BaseEntity {

    private String name;
    private FileDB profilePicture;
}
