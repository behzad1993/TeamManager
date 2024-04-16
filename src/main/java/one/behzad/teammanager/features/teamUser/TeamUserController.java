package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@RestController("/api/user/")
@RestController
@RequestMapping("user")
public class TeamUserController {

    private final TeamUserServiceImpl service;

    private final Logger logger = LoggerFactory.getLogger(TeamUserController.class);

    @Autowired
    public TeamUserController(TeamUserServiceImpl service) {
        this.service = service;
    }

    // TODO: handle not found object
    @GetMapping("/receive/{id}")
    public TeamUser getUser(@PathVariable("id") Long id) {
        this.logger.error("LOG RECEIVE ID");
        return this.service.findTeamUser(id);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody TeamUser user) {
        this.logger.debug("create User");
        this.service.createTeamUser(user);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@PathVariable Long id) {
        this.logger.debug("remove User");
        this.service.deleteTeamUser(id);
    }

    @PatchMapping("/patchUser/{id}")
    public String patchUser(@PathVariable long id, @RequestBody Map<String, String> toPatch) {
        return this.service.updateTeamUser(id, toPatch);
    }
}
