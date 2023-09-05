package kg.mega.crm_mega.model;

import javax.persistence.*;
import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_mentor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
String surname;
String name;
@Enumerated(value = EnumType.STRING)
CourseFormat courseFormat;
@Enumerated(value = EnumType.STRING)
Course course;


}
