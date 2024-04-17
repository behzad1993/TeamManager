package one.behzad.teammanager.models.fileDB;

import jakarta.persistence.ManyToOne;
import one.behzad.teammanager.models.Album;


public class MediaDB extends FileDB {
    @ManyToOne
    private Album albumName;
}
