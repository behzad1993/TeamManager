package one.behzad.teammanager.features.member;

import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Member> findOneById(Long id) {
        return this.repository.findById(id);
    }


    @Override
    public List<MemberDTO> findAll() {
        Iterable<Member> members = this.repository.findAll();
        List<MemberDTO> memberDTOs = new ArrayList<>();

        for (Member member : members) {
            MemberDTO mappedMemberDTO = this.modelMapper.map(member, MemberDTO.class);
            memberDTOs.add(mappedMemberDTO);
        }

        return memberDTOs;
    }

    @Override
    public Member save(Member member) {
        return this.repository.save(member);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    //    TODO: change return value
    @Override
    public boolean update(Long id, Map<String, String> toPatch) {
        long toCompareId = Long.parseLong(toPatch.get("id"));
        if (id != toCompareId) {
//            return "ID of path and request body are not equal";
            return false;
        }

        toPatch.remove("id");

        Optional<Member> oMember = this.repository.findById(id);
        if (oMember.isEmpty()) {
//            return "Member not found";
            return false;
        }
        Member member = oMember.get();

        for (String k : toPatch.keySet()) {
            Field field = ReflectionUtils.findField(Member.class, k);
            if (field == null) {
//                return "field does not exists in object";
                return false;
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, member, toPatch.get(k));
        }

        this.repository.save(member);
//        return "team user update successful";
        return true;
    }
}