package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;

public interface TeamUserService {

    TeamUser findTeamUser(Long id);

    void createTeamUser(TeamUser user);

    void deleteTeamUser(Long id);

    void updateUser(TeamUser user);
}
