package one.behzad.teammanager.features.member;

import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberService {
    Optional<Member> findOneById(Long id);

    List<MemberDTO> findAll();

    Member save(Member member);

    void delete(Long id);

    boolean update(Long id, Map<String, String> map);
}
