package one.behzad.teammanager.features;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    List<T> findAll();

    T find(Long id);

    void insert(T o);

    void delete(Long id);

    String update(Long id, Map<String, String> map);
}
