package one.behzad.teammanager.DTOs;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberDTO extends TypeReferenceDTO {
    private String surName;
    private String lastName;
}
