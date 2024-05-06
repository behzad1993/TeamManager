package one.behzad.teammanager.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    long id;
}
