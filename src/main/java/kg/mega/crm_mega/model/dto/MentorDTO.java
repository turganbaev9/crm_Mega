package kg.mega.crm_mega.model.dto;
import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
public class MentorDTO {
Long id;
    String surname;
    String name;
    @Enumerated(value = EnumType.STRING)
    CourseFormat courseFormat;
    @Enumerated(value = EnumType.STRING)
    Course course;




}
