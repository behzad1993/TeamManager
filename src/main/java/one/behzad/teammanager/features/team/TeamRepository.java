package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Override
    List<Team> findAll();

}
