package one.behzad.teammanager.DTOs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO extends TypeReferenceDTO {
    private String surName;
    private String lastName;
}
