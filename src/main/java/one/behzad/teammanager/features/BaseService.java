package one.behzad.teammanager.features;

import java.util.Map;

public interface BaseService<T> {

    T find(Long id);

    void insert(T o);

    void delete(Long id);

    String update(Long id, Map<String, String> map);
}
