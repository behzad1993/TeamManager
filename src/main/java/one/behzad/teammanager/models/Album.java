package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import one.behzad.teammanager.models.fileDB.MediaDB;

import java.util.List;

@Entity
public class Album extends BaseEntity {

    private String name;

    @OneToMany
    private List<MediaDB> mediaDBList;
}
