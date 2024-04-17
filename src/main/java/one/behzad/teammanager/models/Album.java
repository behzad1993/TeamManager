package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
class Album extends BaseEntity {

    private String name;

    @OneToMany
    private List<MediaDB> mediaDBList;
}
