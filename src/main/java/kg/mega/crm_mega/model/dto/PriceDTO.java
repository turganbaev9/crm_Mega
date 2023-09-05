package kg.mega.crm_mega.model.dto;
import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class PriceDTO {
    Long id;
    @Enumerated(value= EnumType.STRING)
    private Course          course;
    private Double          price;
    private CourseFormat courseFormat;
    private StudentsDTO students;
    private    Double   paid;
 private    Double leftSum;

}