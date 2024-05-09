package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    List<Member> findAll();

    List<Team> findMembersById(Long id);
}
