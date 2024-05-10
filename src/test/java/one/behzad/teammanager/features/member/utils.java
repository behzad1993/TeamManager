package one.behzad.teammanager.features.member;

import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;

import java.util.ArrayList;

class utils {

    static Member createMember(long id) {
        return new Member(id, "a", "b");
    }

    static Member createMember() {
        return new Member("a", "b");
    }

    static MemberDTO createMemberDTO() {
        return new MemberDTO("a", "b");
    }

    static MemberDTO createMemberDTOFalse() {
        return new MemberDTO("a", null);
    }

    static ArrayList<Member> createMembers(int times) {
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            members.add(new Member("a", "b"));
        }
        return members;
    }


    static ArrayList<Member> getMembers() {
        Member tmp1 = new Member(1L, "a", "a");
        Member tmp2 = new Member(2L, "b", "b");
        Member tmp3 = new Member(3L, "c", "c");
        Member tmp4 = new Member(4L, "d", "d");
        ArrayList<Member> memberDTOS = new ArrayList<>();
        memberDTOS.add(tmp1);
        memberDTOS.add(tmp2);
        memberDTOS.add(tmp3);
        memberDTOS.add(tmp4);
        return memberDTOS;
    }


    static ArrayList<MemberDTO> getMemberDTOs() {
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
}
