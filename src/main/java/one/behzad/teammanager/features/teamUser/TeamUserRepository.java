package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.models.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamUserRepository extends BaseRepository<Member, Long> {
}
