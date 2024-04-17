package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class ClipDB extends MediaDB {

    private MediaType type = MediaType.CLIP;
}
