package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.features.BaseController;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class TeamUserController extends BaseController<Member> {

    private final TeamUserServiceImpl service;

    @Autowired
    public TeamUserController(TeamUserServiceImpl service) {
        this.service = service;
    }

    @Override
    protected BaseService<Member> getService() {
        return this.service;
    }
}
