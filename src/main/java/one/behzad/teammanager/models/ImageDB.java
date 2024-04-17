package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
class ImageDB extends MediaDB {

    private MediaType type = MediaType.IMAGE;
}
