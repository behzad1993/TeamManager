package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.features.BaseServiceImpl;
import one.behzad.teammanager.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamUserServiceImpl extends BaseServiceImpl<Member> implements BaseService<Member> {

    private final TeamUserRepository repository;

    @Autowired
    public TeamUserServiceImpl(TeamUserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Member, Long> getRepository() {
        return this.repository;
    }
}
