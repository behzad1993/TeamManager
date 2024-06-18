package one.behzad.teammanager.features.team;

import one.behzad.teammanager.models.Team;

import java.util.ArrayList;
import java.util.List;

class UtilsTeam {

    static Team createTeamWithoutMember() {
        return new Team("name", "sports", List.of());
    }

    static List<Team> createTeamsWithoutMember(int times) {
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            teams.add(createTeamWithoutMember());
        }
        return teams;
    }
}
