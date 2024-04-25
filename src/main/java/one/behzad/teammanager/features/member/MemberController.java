package one.behzad.teammanager.features.member;

import one.behzad.teammanager.features.BaseController;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class MemberController extends BaseController<Member> {

    private final MemberServiceImpl service;

    @Autowired
    public MemberController(MemberServiceImpl service) {
        this.service = service;
    }

    @Override
    protected BaseService<Member> getService() {
        return this.service;
    }
}
