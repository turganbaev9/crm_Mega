package kg.mega.crm_mega.model;
import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.*;
import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(value= EnumType.STRING)
    private Course course;
    private Double price;
    private CourseFormat courseFormat;
    @ManyToOne
    Students students;
    Double paid;
Double leftSum;

}
