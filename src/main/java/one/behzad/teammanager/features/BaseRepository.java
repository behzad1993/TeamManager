package one.behzad.teammanager.features;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    void save(T entity);

    void deleteById(ID id);
}

