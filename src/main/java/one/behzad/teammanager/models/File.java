package one.behzad.teammanager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseEntity {

    @Lob
    byte[] data;
    private String name;
}
