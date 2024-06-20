package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Stroke;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberService {
    Optional<Member> findOneById(Long id);

    List<Member> findAll();

    List<Member> findAllByStroke(Stroke stroke);

    List<Member> findAllIMSwimmers();

    Member save(Member member);

    void delete(Long id);

    boolean update(Long id, Map<String, String> map);
}
