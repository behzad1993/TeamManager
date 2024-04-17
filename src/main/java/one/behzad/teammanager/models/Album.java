package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
class Album extends BaseEntity {

    private String name;

    @ManyToMany
    private List<MediaDB> mediaDBList;
}
