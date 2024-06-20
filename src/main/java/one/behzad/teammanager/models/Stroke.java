package one.behzad.teammanager.models;

import lombok.Getter;

@Getter
public enum Stroke {
    BUTTERFLY("butterfly"),
    BACKSTROKE("backstroke"),
    BREASTSTROKE("breaststroke"),
    FREESTYLE("freestyle"),
    IM("im");

    private final String label;

    Stroke(String label) {
        this.label = label;
    }
}


