package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.models.TeamUser;
import org.springframework.stereotype.Repository;

@Repository
interface TeamUserRepository extends BaseRepository<TeamUser, Long> {
}
