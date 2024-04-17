package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
class MediaDB extends FileDB {

    @ManyToOne
    private Album albumName;
}
