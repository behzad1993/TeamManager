package one.behzad.teammanager.features.member;

import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.features.BaseServiceImpl;
import one.behzad.teammanager.models.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, MemberDTO> implements BaseService<Member, MemberDTO> {

    private final MemberRepository repository;

    @Autowired
    public MemberServiceImpl(MemberRepository repository, ModelMapper modelMapper) {
        super(modelMapper, Member.class, MemberDTO.class);
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Member, Long> getRepository() {
        return this.repository;
    }
}
