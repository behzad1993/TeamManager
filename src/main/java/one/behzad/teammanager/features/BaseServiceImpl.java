package one.behzad.teammanager.features;

import one.behzad.teammanager.models.BaseEntity;
import one.behzad.teammanager.models.Member;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public abstract class BaseServiceImpl<T extends BaseEntity, DTO> implements BaseService<T, DTO> {

    private final ModelMapper modelMapper;
    private final Type genericDBModelClass;
    private final Type genericDBDTOClass;

    public BaseServiceImpl(ModelMapper modelMapper, Type genericDBModelClass, Type genericDBDTOClass) {
        this.modelMapper = modelMapper;
        this.genericDBModelClass = genericDBModelClass;
        this.genericDBDTOClass = genericDBDTOClass;
    }

    protected abstract BaseRepository<T, Long> getRepository();

    @Override
    public List<DTO> findAll() {
        List<T> allEntries = this.getRepository().findAll();
        List<DTO> allEntriesDTO = new ArrayList<>();

        for (T entry : allEntries) {
            DTO dto = this.modelMapper.map(entry, this.genericDBDTOClass);
            allEntriesDTO.add(dto);
        }
        return allEntriesDTO;
    }

    @Override
    public DTO find(Long id) {
        return (DTO) this.getRepository()
                .findById(id)
                .orElse(null);
    }

    @Override
    public void insert(Object o) {
        this.getRepository().save((T) o);
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

        T o = (T) this.find(id);
        for (String k : toPatch.keySet()) {
            Field field = ReflectionUtils.findField(Member.class, k);
            if (field == null) {
                return "field does not exists in object";
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, o, toPatch.get(k));
        }

        this.getRepository().save(o);
        return "team user update successful";
    }

    private Type getSecondTypeReference() {
        Type superclass = this.getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return ((ParameterizedType) superclass).getActualTypeArguments()[1];
    }
}
