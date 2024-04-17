package one.behzad.teammanager.models.fileDB;

public enum MediaType {

    CLIP("clip"),
    GIF("gif"),
    IMAGE("image"),
    VECTOR_GRAPHIC("vector_graphic");

    private final String label;

    MediaType(String label) {
        this.label = label;
    }
}
