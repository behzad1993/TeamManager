package one.behzad.teammanager.features.blog;

import one.behzad.teammanager.features.BaseRepository;
import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.features.BaseServiceImpl;
import one.behzad.teammanager.models.fileDB.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BaseService<Blog> {

    private final BlogRepository repository;

    @Autowired
    BlogServiceImpl(BlogRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Blog, Long> getRepository() {
        return this.repository;
    }
}
