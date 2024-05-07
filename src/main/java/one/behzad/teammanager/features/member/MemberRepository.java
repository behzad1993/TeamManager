package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
