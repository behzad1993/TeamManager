package one.behzad.teammanager.features.blog;

import one.behzad.teammanager.features.BaseService;
import one.behzad.teammanager.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BlogServiceImpl implements BaseService<Blog> {

    private final BlogRepository repository;

    @Autowired
    public BlogServiceImpl(BlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Blog find(Long id) {
        return this.repository.findById(id).isPresent() ? this.repository.findById(id).get() : null;
    }

    @Override
    public void insert(Blog blog) {
        this.repository.save(blog);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public String update(Long id, Map<String, String> map) {
        return "";
    }
}
