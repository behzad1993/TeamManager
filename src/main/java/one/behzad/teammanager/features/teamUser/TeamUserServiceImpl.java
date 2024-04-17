package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.features.BaseServiceImpl;
import one.behzad.teammanager.models.TeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamUserServiceImpl extends BaseServiceImpl<TeamUser> implements BaseService<TeamUser> {

    private final TeamUserRepository repository;

    @Autowired
    TeamUserServiceImpl(TeamUserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<TeamUser, Long> getRepository() {
        return this.repository;
    }
}
