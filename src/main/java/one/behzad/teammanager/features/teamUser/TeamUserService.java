package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;

import java.util.Map;

public interface TeamUserService {

    TeamUser findTeamUser(Long id);

    void createTeamUser(TeamUser user);

    void deleteTeamUser(Long id);

    String updateTeamUser(long id, Map<String, String> toPatch);
}
