package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    @Autowired
    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Team> findOneById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Set<Member> findAllMembersByTeam(Long id) {
        Optional<Team> teamOpt = this.findOneById(id);
        if (teamOpt.isPresent()) {
            return teamOpt.get().getMembers();
        }
        return new HashSet<>();
    }

    @Override
    public Team save(Team team) {
        return this.repository.save(team);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public boolean update(Long id, Map<String, String> toPatch) {
        long toCompareId = Long.parseLong(toPatch.get("id"));
        if (id != toCompareId) {
//            return "ID of path and request body are not equal";
            return false;
        }

        toPatch.remove("id");

        Optional<Team> teamOpt = this.repository.findById(id);
        if (teamOpt.isEmpty()) {
//            return "Member not found";
            return false;
        }
        Team team = teamOpt.get();

        for (String k : toPatch.keySet()) {
            Field field = ReflectionUtils.findField(Member.class, k);
            if (field == null) {
//                return "field does not exists in object";
                return false;
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, team, toPatch.get(k));
        }

        this.repository.save(team);
//        return "team user update successful";
        return true;
    }
}
