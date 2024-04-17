package one.behzad.teammanager.features;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @GetMapping("/get/{id}")
    public T get(@PathVariable Long id) {
        return this.getService().find(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody T o) {
        this.getService().insert(o);
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id) {
        this.getService().delete(id);
    }

    @PatchMapping("/patch/{id}")
    public String patch(@PathVariable long id, @RequestBody Map<String, String> toPatch) {
        return this.getService().update(id, toPatch);
    }
}
