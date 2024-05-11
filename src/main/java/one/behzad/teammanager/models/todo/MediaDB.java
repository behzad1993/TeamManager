//package one.behzad.teammanager.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//
//import java.util.List;
//
//@Getter
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn
//public class MediaDB extends FileDB {
//
//    @ManyToMany
//    private List<Album> albumName;
//
//    public MediaDB(byte[] data, String name, List<Album> albumName) {
//        super(data, name);
//        this.albumName = albumName;
//    }
//
//    public MediaDB() {
//
//    }
//}
