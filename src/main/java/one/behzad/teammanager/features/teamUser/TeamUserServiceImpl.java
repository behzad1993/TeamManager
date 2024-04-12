package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamUserServiceImpl implements TeamUserSerivce {

    private TeamUserRepository repository;

    TeamUserServiceImpl(TeamUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTeamUser(TeamUser user) {
        this.repository.saveOne(user);
    }

    @Override
    public void deleteTeamUser(UUID id) {

    }

    @Override
    public void updateUser(UUID id, TeamUser user) {

    }
}
