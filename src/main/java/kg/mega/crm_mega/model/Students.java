package kg.mega.crm_mega.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
    @Table(name = "tb_students")
public class Students {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String surname;
   private   String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthData;
    private boolean isMarried;
    @Enumerated(value= EnumType.STRING)
    private Course course;
    @Enumerated(value = EnumType.STRING)
    CourseFormat courseFormat;


}
