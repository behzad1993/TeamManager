package one.behzad.teammanager.DTOs;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TeamDTO {

    private String name;
    private String sports;
    private List<MemberDTO> memberDTOs;
}
