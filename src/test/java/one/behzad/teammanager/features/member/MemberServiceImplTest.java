package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static one.behzad.teammanager.features.member.utils.createMember;
import static one.behzad.teammanager.features.member.utils.getMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    private MemberRepository repository;
    private MemberServiceImpl service;


    @BeforeEach
    void init() {
        this.service = new MemberServiceImpl(this.repository);
    }

    @Test
    void findByID_returnMemberByID() {
        // GIVEN
        Optional<Member> expect = Optional.of(createMember(1));

        // WHEN
        when(this.repository.findById(1L)).thenReturn(expect);
        Optional<Member> actual = this.service.findOneById(1L);

        // THEN
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void findByID_returnEmptyMember() {
        // GIVEN
        Optional<Member> expect = Optional.empty();

        // WHEN
        when(this.repository.findById(1L)).thenReturn(expect);
        Optional<Member> actual = this.service.findOneById(1L);

        // THEN
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void findAll_returnAllMembers() {
        // GIVEN
        ArrayList<Member> expected = getMembers();

        // WHEN
        when(this.repository.findAll()).thenReturn(expected);
        List<Member> actual = this.service.findAll();

        // THEN

        assertThat(actual).containsAll(expected);
    }

    @Test
    void save_ShouldBeCalledOnce() {
        // WHEN
        this.service.save(createMember(1L));

        // THEN
        verify(this.repository).save(any());
    }


    @Test
    void update_shouldReturnFalseIfIDsArentEqual() {
        // GIVEN
        long id = 2L;

        // WHEN
        boolean actual = this.service.update(id, Map.of("id", "1"));

        // THEN
        assertThat(actual).isFalse();
    }

    @Test
    void update_shouldReturnFalseIfMemberIsNotPresent() {
        // GIVEN
        long id = 1L;
        Member member = createMember(id);

        // WHEN
        when(this.repository.findById(id)).thenReturn(Optional.empty());

        Map<String, String> toPatchCopy = Map.of("id", "1");
        HashMap<String, String> toPatch = new HashMap<>(toPatchCopy);

        boolean actual = this.service.update(id, toPatch);

        // THEN
        assertThat(actual).isFalse();
    }

    @Test
    void update_shouldReturnFalseIfFieldDoesntExist() {
        // GIVEN
        long id = 1L;

        // WHEN
        when(this.repository.findById(id)).thenReturn(Optional.empty());
        Map<String, String> toPatchCopy = Map.of("id", "1", "surName", "name", "wrongField", "wrongFieldValue");
        HashMap<String, String> toPatch = new HashMap<>(toPatchCopy);
        boolean actual = this.service.update(id, toPatch);

        // THEN
        assertThat(actual).isFalse();
    }

    @Test
    void update_shouldReturnTrueIfGivenMapIsCorrect() {
        // GIVEN
        long id = 1L;

        // WHEN
        when(this.repository.findById(id)).thenReturn(Optional.of(createMember(id)));
        Map<String, String> toPatchCopy = Map.of("id", String.valueOf(id), "surName", "name");
        HashMap<String, String> toPatch = new HashMap<>(toPatchCopy);
        boolean actual = this.service.update(id, toPatch);

        // THEN
        assertThat(actual).isTrue();
    }
}
