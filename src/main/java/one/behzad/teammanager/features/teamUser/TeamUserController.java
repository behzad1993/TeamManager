package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//
//    @GetMapping("/")
//    public TeamUser test() {
//        this.logger.error("BASE");
//        return this.service.findTeamUser(UUID.fromString("7e230f61-7b58-449b-95d0-d115727935fe"));
//    }
//
//    @GetMapping("/receive")
//    public TeamUser test2() {
//        this.logger.error("LOG RECEIVE");
//        return this.service.findTeamUser(UUID.fromString("7e230f61-7b58-449b-95d0-d115727935fe"));
//    }
//
//    @GetMapping("/create")
//    public TeamUser test3() {
//        this.logger.error("LOG CREATE");
//        return this.service.findTeamUser(UUID.fromString("7e230f61-7b58-449b-95d0-d115727935fe"));
//    }

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
//
//    @PostMapping("/updateUser/{id}")
//    public void updateUser(@RequestBody TeamUser user) {
//        this.service.updateUser(user);
//    }
//
//    @DeleteMapping("/removeUser/{id}")
//    public void removeUser(@PathVariable UUID id) {
//        this.logger.debug("remove User");
//        this.service.deleteTeamUser(id);
//    }
}
