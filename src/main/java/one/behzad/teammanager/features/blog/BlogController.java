package one.behzad.teammanager.features.blog;

import one.behzad.teammanager.features.BaseController;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.models.fileDB.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog")
public class BlogController extends BaseController<Blog> {

    private final BlogServiceImpl service;

    @Autowired
    public BlogController(BlogServiceImpl service) {
        this.service = service;
    }

    @Override
    protected BaseService<Blog> getService() {
        return this.service;
    }
}
