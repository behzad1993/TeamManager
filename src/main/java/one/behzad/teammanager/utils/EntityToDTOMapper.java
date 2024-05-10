package one.behzad.teammanager.utils;

public class EntityToDTOMapper {
    private static EntityToDTOMapper MAPPER;

    private EntityToDTOMapper() {}

    public static EntityToDTOMapper getMAPPER() {
        if (MAPPER == null) {
            MAPPER = new EntityToDTOMapper();
        }

        return MAPPER;
    }
}
