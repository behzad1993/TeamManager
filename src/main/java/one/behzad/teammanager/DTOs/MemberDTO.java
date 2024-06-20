package one.behzad.teammanager.DTOs;

import lombok.*;
import one.behzad.teammanager.models.StrokeOrder;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberDTO extends TypeReferenceDTO {

    private String surName;
    private String lastName;
    private String email;
    private String phoneNr;
    private StrokeOrder strokeOrder;
    private Date birthday;

    public MemberDTO(String surName, String lastName) {
        this.surName = surName;
        this.lastName = lastName;
    }
}
