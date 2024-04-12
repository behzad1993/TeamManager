package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;

import java.util.UUID;

public interface TeamUserSerivce {
    public abstract void createTeamUser(TeamUser user);

    public abstract void deleteTeamUser(UUID id);

    public abstract void updateUser(UUID id, TeamUser user);
}
