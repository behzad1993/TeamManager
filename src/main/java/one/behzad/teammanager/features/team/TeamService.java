package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TeamService {
    Optional<Team> findOneById(Long id);

    List<Team> findAll();

    Member save(Member member);

    void delete(Long id);

    boolean update(Long id, Map<String, String> map);
}
