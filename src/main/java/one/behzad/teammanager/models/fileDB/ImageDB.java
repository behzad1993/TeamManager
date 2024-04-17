package one.behzad.teammanager.models.fileDB;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class ImageDB extends MediaDB {

    private MediaType type = MediaType.IMAGE;
}
