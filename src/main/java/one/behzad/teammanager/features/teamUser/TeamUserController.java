package one.behzad.teammanager.features.teamUser;

import one.behzad.teammanager.models.TeamUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/api/user")
public class TeamUserController {

    @GetMapping("/getUser/{id}")
    public TeamUser getUser() {
        return null;
    }
}
