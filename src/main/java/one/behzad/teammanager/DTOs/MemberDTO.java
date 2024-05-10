package one.behzad.teammanager.DTOs;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberDTO extends TypeReferenceDTO {
    private String surName;
    private String lastName;
    private String email;
    private String phoneNr;
    private Date birthday;
}
