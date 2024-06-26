package one.behzad.teammanager.features.team;

import io.swagger.v3.oas.annotations.Operation;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.DTOs.TeamDTO;
import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static one.behzad.teammanager.utils.Mapper.getMapper;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service, ModelMapper modelMapper) {
        this.service = service;
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Team by ID")
    public ResponseEntity<TeamDTO> findOneById(@PathVariable Long id) {
        Optional<Team> team = this.service.findOneById(id);


        return team.map(t -> {
                    TeamDTO mappedDTO = getMapper().map(t, TeamDTO.class);
                    return ResponseEntity.ok().body(mappedDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getAll() {
        List<Team> teams = this.service.findAll();

        if (teams.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (Team team : teams) {
            TeamDTO teamDTO = getMapper().map(team, TeamDTO.class);
            teamDTOS.add(teamDTO);
        }

        return ResponseEntity.ok().body(teamDTOS);
    }


    @GetMapping("/members/{id}")
    public ResponseEntity<List<MemberDTO>> getAllMembersOfTeam(@PathVariable Long id) {
        List<Member> members = this.service.findAllMembersByTeam(id);

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = getMapper().map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }

        return ResponseEntity.ok().body(memberDTOS);
    }


    @PostMapping("/save")
    public ResponseEntity<TeamDTO> addTeam(@RequestBody TeamDTO teamDTO) {
        Team mappedTeam = getMapper().map(teamDTO, Team.class);
        this.service.save(mappedTeam);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamDTO);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PatchMapping("/patch/{id}")
    public ResponseEntity<String> patch(@PathVariable long id, @RequestBody Map<String, String> toPatch) {
        if (this.service.update(id, toPatch)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
