package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller("/api/user")
public class TeamUserController {

    private final TeamUserServiceImpl service;

    @Autowired
    public TeamUserController(TeamUserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/getUser/{id}")
    public TeamUser getUser(@PathVariable UUID id) {
        return this.service.findTeamUser(id);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody TeamUser user) {
        this.service.createTeamUser(user);
    }

    @PostMapping("/updateUser/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody TeamUser user) {
        this.service.updateUser(id, user);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@PathVariable UUID id) {
        this.service.deleteTeamUser(id);
    }
}
