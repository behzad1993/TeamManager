package one.behzad.teammanager.models;

import jakarta.persistence.*;
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
//@ToString
@Table(name = "strokes")
public class StrokeOrder extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Stroke first;
    @Enumerated(EnumType.STRING)
    private Stroke second;
    @Enumerated(EnumType.STRING)
    private Stroke third;
    @Enumerated(EnumType.STRING)
    private Stroke fourth;
    @Enumerated(EnumType.STRING)
    private Stroke fifth;

    private Boolean showFirst;
    private Boolean showSecond;
    private Boolean showThird;
    private Boolean showFourth;
    private Boolean showFifth;

    @Column(name = "is_im_swimmer")
    private Boolean isIMSwimmer;

//    @Override
//    public String toString() {
//        String string = new StringBuilder().append("StrokeOrder(")
//                .append("first = ")
//                .append(this.first)
//                .append("second = ")
//                .append(this.second)
//                .append("third = ")
//                .append(this.third)
//                .append("fourth = ")
//                .append(this.fourth)
//                .append("fifth = ")
//                .append(this.fifth)
//                .append("showFirst = ")
//                .append(this.showFirst)
//                .append("showSecond = ")
//                .append(this.showSecond)
//                .append("showThird = ")
//                .append(this.showThird)
//                .append("showFourth = ")
//                .append(this.showFourth)
//                .append("showFifth = ")
//                .append(this.showFifth)
//                .append("isIMSwimmer = ")
//                .append(this.isIMSwimmer)
//                .append(")").toString();
//        return string;
//    }
}
