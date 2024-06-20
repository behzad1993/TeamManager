package one.behzad.teammanager.features.member;

import io.swagger.v3.oas.annotations.Operation;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.StrokeRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class MemberController {

    private final MemberService service;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get Member by ID")
    public ResponseEntity<MemberDTO> findOneById(@PathVariable Long id) {
        Optional<Member> member = this.service.findOneById(id);

        return member.map(m -> {
                    MemberDTO mappedDTO = this.modelMapper.map(m, MemberDTO.class);
                    return ResponseEntity.ok().body(mappedDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/users")
    public ResponseEntity<List<MemberDTO>> getAll() {
        List<Member> members = this.service.findAll();

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = this.modelMapper.map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }

        return ResponseEntity.ok().body(memberDTOS);
    }


    @PostMapping("/save")
    public ResponseEntity<MemberDTO> addMember(@RequestBody MemberDTO memberDTO) {
        Member mappedMember = this.modelMapper.map(memberDTO, Member.class);
        this.service.save(mappedMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberDTO);
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


    @GetMapping("/stroke")
    public ResponseEntity<List<MemberDTO>> getMembersByStroke(@RequestBody StrokeRequest stroke) {
        List<Member> members = this.service.findAllByStroke(stroke.stroke());

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = this.modelMapper.map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }

        return ResponseEntity.ok().body(memberDTOS);
    }

    @GetMapping("/im")
    public ResponseEntity<List<MemberDTO>> getAllIMSwimmer() {
        List<Member> members = this.service.findAllIMSwimmers();

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = this.modelMapper.map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }

        return ResponseEntity.ok().body(memberDTOS);
    }
}
