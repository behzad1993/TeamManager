package one.behzad.teammanager.features;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import one.behzad.teammanager.models.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @GetMapping("/get/{id}")
    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the TeamUser",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Member.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "TeamUser not found",
                    content = @Content)})
    public T get(@PathVariable Long id) {
        System.out.println("get request with id: " + id);
        return this.getService().find(id);
    }

    @GetMapping("/getAll")
    public List<T> getAll() {
        return this.getService().findAll();
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
