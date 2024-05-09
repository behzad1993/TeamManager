package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    @Autowired
    public TeamServiceImpl(TeamRepository repository) {this.repository = repository;}

    @Override
    public Optional<Team> findOneById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean update(Long id, Map<String, String> map) {
        return false;
    }
}
