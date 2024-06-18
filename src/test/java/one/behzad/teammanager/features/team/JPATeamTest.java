package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static one.behzad.teammanager.features.team.utilsTeam.createTeamWithoutMember;
import static one.behzad.teammanager.features.team.utilsTeam.createTeamsWithoutMember;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.sql.init.mode=never"
})
class JPATeamTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TeamRepository repository;

    @Test
    public void contextLoads() {
        assertThat(this.em).isNotNull();
    }

    @Test
    void whenRepositoryIsEmpty_returnNoTeam() {
        Iterable<Team> expected = this.repository.findAll();
        assertThat(expected).isEmpty();
    }

    @Test
    void shouldSaveTeam() {
        Team expected = createTeamWithoutMember();
        Team actual = this.repository.save(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenTeamWithIdExists_returnTeam() {
        Team expected = createTeamWithoutMember();
        this.em.persist(expected);

        Optional<Team> actual = this.repository.findById(expected.getId());

        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get()).isEqualTo(expected);
    }

    @Test
    void whenMultipleTeamsExisting_returnAll() {
        List<Team> expected = createTeamsWithoutMember(5);
        for (Team team : expected) {
            this.em.persist(team);
        }

        List<Team> actual = this.repository.findAll();

        assertThat(actual).hasSize(5).containsAll(expected);
    }

    @Test
    void should_patch_member() {
        String sport = "changeSports";
        String name = "changeName";
        Team team = createTeamWithoutMember();
        this.em.persist(team);

        Team toUpdate = this.repository.findById(team.getId()).orElseThrow();
        toUpdate.setName(name);
        toUpdate.setSports(sport);
        this.repository.save(toUpdate);

        Team actual = this.repository.findById(team.getId()).orElseThrow();
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(actual.getSports()).isEqualTo(sport);
    }

    @Test
    void should_delete_member_by_id() {
        List<Team> teams = createTeamsWithoutMember(5);
        for (Team team : teams) {
            this.em.persist(team);
        }

        this.repository.deleteById(teams.getFirst().getId());
        List<Team> actual = this.repository.findAll();

        assertThat(actual).hasSize(4).containsAll(teams.subList(1, 4));

    }
}
