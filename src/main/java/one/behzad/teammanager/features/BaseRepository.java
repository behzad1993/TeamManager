package one.behzad.teammanager.features;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T findOne(ID id);

    T saveOne(T entity);

    T deleteOne(ID id);
}

