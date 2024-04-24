//package one.behzad.teammanager.utils;
//
//import one.behzad.teammanager.features.teamUser.TeamUserServiceImpl;
//import one.behzad.teammanager.models.Team;
//import one.behzad.teammanager.models.TeamUser;
//
//import java.util.Collections;
//import java.util.Date;
//
//public class FillDatabaseHelper {
//
//    public static void buildTeamUser() {
//        TeamUser teamUser = new TeamUser().builder()
//                .email("behzad@karimi.de")
//                .birthday(new Date(1993, 3, 16))
//                .phoneNr("0176 666777888")
//                .surName("Behzad")
//                .lastName("Karimi")
//                .team(Collections.singletonList(new Team("die coolsten")))
//                .build();
//
//        new TeamUserServiceImpl();
//        teamUserRepository.save(teamUser);
//
//    }
//
//    private static Team createTeam(String name) {
//        return new Team(name);
//    }
//}
