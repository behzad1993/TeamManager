package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import one.behzad.teammanager.models.fileDB.FileDB;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Team extends BaseEntity {

    private String name;
    private FileDB profilePicture;
}
