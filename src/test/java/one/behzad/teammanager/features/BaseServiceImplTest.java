package one.behzad.teammanager.features;

import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.features.member.MemberRepository;
import one.behzad.teammanager.features.member.MemberServiceImpl;
import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseServiceImplTest {

    @Mock
    MemberRepository repository;

    private static ArrayList<Member> getMembers() {
        Member tmp1 = new Member("a", "a");
        Member tmp2 = new Member("b", "b");
        Member tmp3 = new Member("c", "c");
        Member tmp4 = new Member("d", "d");
        ArrayList<Member> memberDTOS = new ArrayList<>();
        memberDTOS.add(tmp1);
        memberDTOS.add(tmp2);
        memberDTOS.add(tmp3);
        memberDTOS.add(tmp4);
        return memberDTOS;
    }

    private static ArrayList<MemberDTO> getMembersDTO() {
        MemberDTO tmp1 = new MemberDTO("a", "a");
        MemberDTO tmp2 = new MemberDTO("b", "b");
        MemberDTO tmp3 = new MemberDTO("c", "c");
        MemberDTO tmp4 = new MemberDTO("d", "d");
        ArrayList<MemberDTO> memberDTOS = new ArrayList<>();
        memberDTOS.add(tmp1);
        memberDTOS.add(tmp2);
        memberDTOS.add(tmp3);
        memberDTOS.add(tmp4);
        return memberDTOS;
    }

    @Test
    void findAllTest() {
        ArrayList<Member> members = getMembers();
        ArrayList<MemberDTO> membersDTO = getMembersDTO();

        when(this.repository.findAll()).thenReturn(members);

        MemberServiceImpl service = new MemberServiceImpl(this.repository, new ModelMapper());
        List<MemberDTO> all = service.findAll();

        assertIterableEquals(all, membersDTO);
    }


}