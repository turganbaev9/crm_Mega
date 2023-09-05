package kg.mega.crm_mega.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.crm_mega.model.enums.Course;
import kg.mega.crm_mega.model.enums.CourseFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@Table(name = "tb_countMoney")
public class CountMoney {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double salary;

    @JsonFormat(pattern= "dd-MM-yyyy")
    LocalDate       employPresentDayStart;
    @JsonFormat(pattern= "dd-MM-yyyy")
    LocalDate       employPresentDayEnd;
    @JsonFormat(pattern= "dd-MM-yyyy")
    LocalDate       apsentDaysOfEmployStart;
    @JsonFormat(pattern= "dd-MM-yyyy")
    LocalDate       apsentDaysOfEmloyEnd;
    CourseFormat courseFormat;
    Course course;
    @ManyToOne
    Mentor mentor;
    @ManyToOne
    Price price;
    Double dailyRate;
    Double leftCredit;
    Integer appsentDay;
}
