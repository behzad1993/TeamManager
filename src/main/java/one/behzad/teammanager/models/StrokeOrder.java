package one.behzad.teammanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Stroke Order model
 *
 * @author Behzad Karimi
 * <p>
 * defines the stroke order of a swimmer
 * the boolean in each pair represents the 'isVisible' value for the frontend
 */
@EqualsAndHashCode(callSuper = false)
@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "strokes")
class StrokeOrder extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    private Stroke first;
    @Enumerated(EnumType.ORDINAL)
    private Stroke second;
    @Enumerated(EnumType.ORDINAL)
    private Stroke third;
    @Enumerated(EnumType.ORDINAL)
    private Stroke fourth;
    @Enumerated(EnumType.ORDINAL)
    private Stroke fifth;

//    private Boolean showFirst;
//    private Boolean showSecond;
//    private Boolean showThird;
//    private Boolean showFourth;
//    private Boolean isIMSwimmer;
}
