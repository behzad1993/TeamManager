package one.behzad.teammanager.features.member;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.features.BaseServiceImpl;
import one.behzad.teammanager.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member> implements BaseService<Member> {

    private final MemberRepository repository;

    @Autowired
    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Member, Long> getRepository() {
        return this.repository;
    }
}
