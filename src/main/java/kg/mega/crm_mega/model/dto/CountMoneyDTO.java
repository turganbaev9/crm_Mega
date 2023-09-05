package kg.mega.crm_mega.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;


import kg.mega.crm_mega.model.enums.*;


import lombok.Data;

import java.time.LocalDate;
@Data
public class CountMoneyDTO {

Long id;
        Double          salary;
        @JsonFormat(pattern= "dd-MM-yyyy")
        LocalDate       employPresentDayStart;
        @JsonFormat(pattern= "dd-MM-yyyy")
        LocalDate       employPresentDayEnd;
        @JsonFormat(pattern= "dd-MM-yyyy")
        LocalDate       apsentDaysOfEmployStart;
        @JsonFormat(pattern= "dd-MM-yyyy")
        LocalDate       apsentDaysOfEmloyEnd;
        CourseFormat    courseFormat;
        Course          course;
        MentorDTO       mentor;
        PriceDTO        price;
        Double leftCredit;
        Double dailyRate;
        Integer appsentDay;


}
