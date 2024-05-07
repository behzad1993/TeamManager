package one.behzad.teammanager.features.member;

import io.swagger.v3.oas.annotations.Operation;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<MemberDTO> memberDTOs = this.service.findAll();

        if (memberDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(memberDTOs);
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
}
