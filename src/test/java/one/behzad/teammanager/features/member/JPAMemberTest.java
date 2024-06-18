package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Optional;

import static one.behzad.teammanager.features.member.UtilsMember.createMember;
import static one.behzad.teammanager.features.member.UtilsMember.createMembers;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.sql.init.mode=never"
})
class JPAMemberTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MemberRepository repository;

    @Test
    public void contextLoads() {
        assertThat(this.em).isNotNull();
    }

    @Test
    void should_find_no_Member_if_repository_is_empty() {
        Iterable<Member> expected = this.repository.findAll();
        assertThat(expected).isEmpty();
    }

    @Test
    void should_save_member() {
        Member expected = createMember();
        Member actual = this.repository.save(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_find_member_by_id() {
        Member expect = createMember();
        this.em.persist(expect);

        Optional<Member> actualOpt = this.repository.findById(expect.getId());

        assertThat(actualOpt.isPresent()).isTrue();
        assertThat(actualOpt.get()).isEqualTo(expect);
    }

    @Test
    void should_find_all_member() {
        ArrayList<Member> members = createMembers(5);
        for (Member member : members) {
            this.em.persist(member);
        }

        Iterable<Member> actual = this.repository.findAll();

        assertThat(actual).hasSize(5).containsAll(members);
    }

    @Test
    void should_patch_member() {
        Member member = createMember();
        this.em.persist(member);

        Member toUpdate = this.repository.findById(member.getId()).orElseThrow();
        toUpdate.setSurName("changeSurname");
        toUpdate.setLastName("changeLastName");
        this.repository.save(toUpdate);

        Member actual = this.repository.findById(member.getId()).orElseThrow();
        assertThat(actual.getSurName()).isEqualTo("changeSurname");
        assertThat(actual.getLastName()).isEqualTo("changeLastName");
    }

    @Test
    void should_delete_member_by_id() {
        ArrayList<Member> members = createMembers(5);
        for (Member member : members) {
            this.em.persist(member);
        }

        this.repository.deleteById(members.getFirst().getId());
        Iterable<Member> actual = this.repository.findAll();

        assertThat(actual).hasSize(4).containsAll(members.subList(1, 4));

    }
}
