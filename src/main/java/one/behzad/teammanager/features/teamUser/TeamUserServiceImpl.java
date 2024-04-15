package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamUserServiceImpl implements TeamUserService {

    private final TeamUserRepository repository;

    @Autowired
    TeamUserServiceImpl(TeamUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamUser findTeamUser(UUID id) {
        return this.repository.findById(id).isPresent() ? this.repository.findById(id).get() : null;
    }

    @Override
    public void createTeamUser(TeamUser user) {
        this.repository.save(user);
    }

    @Override
    public void deleteTeamUser(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public void updateUser(UUID id, TeamUser user) {

    }
}
