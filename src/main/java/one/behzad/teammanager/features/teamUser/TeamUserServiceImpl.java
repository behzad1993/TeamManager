package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class TeamUserServiceImpl implements TeamUserService {

    private final TeamUserRepository repository;

    @Autowired
    TeamUserServiceImpl(TeamUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamUser findTeamUser(Long id) {
        return this.repository.findById(id).isPresent() ? this.repository.findById(id).get() : null;
    }

    @Override
    public void createTeamUser(TeamUser user) {
        this.repository.save(user);
    }

    @Override
    public void deleteTeamUser(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public String updateTeamUser(long id, Map<String, String> toPatch) {
        long toCompareId = Long.parseLong(toPatch.get("id"));
        if (id != toCompareId) {
            return "ID of path and request body are not equal";
        }

        toPatch.remove("id");

        TeamUser teamUser = this.findTeamUser(id);
        for (String k : toPatch.keySet()) {
            Field field = ReflectionUtils.findField(TeamUser.class, k);
            if (field == null) {
                return "field does not exists in object";
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, teamUser, toPatch.get(k));
        }

        this.repository.save(teamUser);
        return "team user update successful";
    }
}
