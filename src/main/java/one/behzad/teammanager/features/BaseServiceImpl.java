package one.behzad.teammanager.features;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseRepository<T, Long> getRepository();

    @Override
    public T find(Long id) {
        return this.getRepository()
                .findById(id)
                .orElse(null);
    }

    @Override
    public void insert(T o) {
        this.getRepository().save(o);
    }

    @Override
    public void delete(Long id) {
        this.getRepository().deleteById(id);
    }

    @Override
    public String update(Long id, Map<String, String> toPatch) {
        long toCompareId = Long.parseLong(toPatch.get("id"));
        if (id != toCompareId) {
            return "ID of path and request body are not equal";
        }

        toPatch.remove("id");

        T o = this.find(id);
        for (String k : toPatch.keySet()) {
            Field field = ReflectionUtils.findField(TeamUser.class, k);
            if (field == null) {
                return "field does not exists in object";
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, o, toPatch.get(k));
        }

        this.getRepository().save(o);
        return "team user update successful";
    }
}
