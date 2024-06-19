package one.behzad.teammanager.models;

public enum Stroke {
    BUTTERFLY("butterfly"),
    BACKSTROKE("backstroke"),
    BREASTSTROKE("breaststroke"),
    FREESTYLE("freestyle"),
    ;

    public final String label;

    Stroke(String label) {
        this.label = label;
    }
}
