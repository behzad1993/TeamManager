package one.behzad.teammanager.features;

import java.util.List;
import java.util.Map;

public interface BaseService<T, DTO> {

    List<DTO> findAll();

    DTO find(Long id);

    void insert(DTO o);

    void delete(Long id);

    String update(Long id, Map<String, String> map);
}
