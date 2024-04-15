package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;

import java.util.UUID;

public interface TeamUserService {

    TeamUser findTeamUser(UUID id);

    void createTeamUser(TeamUser user);

    void deleteTeamUser(UUID id);

    void updateUser(UUID id, TeamUser user);
}
