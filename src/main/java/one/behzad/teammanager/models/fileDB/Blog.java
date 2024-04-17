package one.behzad.teammanager.models.fileDB;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import one.behzad.teammanager.models.BaseEntity;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {

    private String title;
    private String text;

    @OneToOne
    private ImageDB banner;

    @ManyToMany
    private List<FileDB> fileDBList;

    @ManyToMany
    private List<ImageDB> mediaDBList;
}
