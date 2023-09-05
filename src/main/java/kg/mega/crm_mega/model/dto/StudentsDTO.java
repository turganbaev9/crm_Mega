package kg.mega.crm_mega.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentsDTO {
    private     Long id;
    private             String surname;
    private             String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate   birthData;
    private boolean     isMarried;
   // @Enumerated(value= EnumType.STRING)
    private Course      course;
 //   @Enumerated (value = EnumType.STRING)
    CourseFormat        courseFormat;

}
