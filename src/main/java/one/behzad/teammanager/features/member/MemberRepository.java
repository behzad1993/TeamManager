package one.behzad.teammanager.features.member;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.models.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends BaseRepository<Member, Long> {
}
