package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
@Data
public class MediaDB extends BaseEntity {

    private String name;
    private String mediaType;

    @Lob
    private byte[] data;

    @ManyToOne
    private Album albumName;
}
