package one.behzad.teammanager.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FileDB extends BaseEntity {

    @Lob
    byte[] data;
    private String name;
    private String mimeType;
}
