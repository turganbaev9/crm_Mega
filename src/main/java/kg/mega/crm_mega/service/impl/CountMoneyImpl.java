package kg.mega.crm_mega.service.impl;
import kg.mega.crm_mega.mapper.CountMoneyMapper;
import kg.mega.crm_mega.model.CountMoney;
import kg.mega.crm_mega.model.Mentor;
import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.dto.CountMoneyDTO;
import kg.mega.crm_mega.repository.CountMoneyRepo;
import kg.mega.crm_mega.repository.MentorRepo;
import kg.mega.crm_mega.repository.PriceRepo;
import kg.mega.crm_mega.repository.StudentRepo;
import kg.mega.crm_mega.service.CountMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CountMoneyImpl implements CountMoneyService {
  private  final CountMoneyRepo countMoneyRepo;
  private final MentorRepo mentorRepo;
  private final PriceRepo priceRepo;
    @Override
    public CountMoneyDTO save(CountMoneyDTO countMoneyDTO) {
         CountMoney countMoney = CountMoneyMapper.INSTANCE.toEntity(countMoneyDTO);
        Mentor mentor=mentorRepo.findById(countMoneyDTO. getMentor().getId()).orElseThrow(()->new NoSuchElementException("Mentor with this ID not found"+countMoneyDTO.getMentor().getId()));
        Price price=priceRepo.findById(countMoneyDTO.getPrice().getId()).orElseThrow(()->new NoSuchElementException("Price with this ID not found"+countMoneyDTO.getPrice().getId()));
       countMoney.setMentor(mentor);
        countMoney.setPrice(price);
       salaryCountDay(countMoney);
        countMoneyRepo.save(countMoney);
  return CountMoneyMapper.INSTANCE.toDTO(countMoney);
    }


    private  void salaryCountDay(CountMoney countMoney){
        LocalDate startPresentDay=countMoney.getEmployPresentDayStart();
        LocalDate endPresentDay=countMoney.getEmployPresentDayEnd();
        LocalDate startApsentDay=countMoney.getApsentDaysOfEmployStart();
        LocalDate endApsentDay=countMoney.getApsentDaysOfEmloyEnd();
        Long daysPresent= ChronoUnit.DAYS.between(startPresentDay,endPresentDay);
    Long daysApsent=ChronoUnit.DAYS.between(startApsentDay,endApsentDay);
    countMoney.setAppsentDay(Math.toIntExact(daysApsent));
Double dailyRate=countMoney.getDailyRate();
Double salry=daysPresent*dailyRate;
countMoney.setSalary(salry);

//
    }

    @Override
    public CountMoneyDTO update(CountMoneyDTO countMoneyDTO) {
CountMoney exist= countMoneyRepo.findById(countMoneyDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Count with this ID"+countMoneyDTO.getId()+"not found"));
  if (countMoneyDTO.getSalary()!=null){
      exist.setSalary(countMoneyDTO.getSalary());

  }

        Optional.ofNullable(countMoneyDTO.getCourseFormat()).ifPresent(exist::setCourseFormat);
Optional.ofNullable(countMoneyDTO.getCourse()).ifPresent(exist::setCourse);

    CountMoney updated= countMoneyRepo.save(exist);
    return CountMoneyMapper.INSTANCE.toDTO(updated);}



    @Override
    public CountMoneyDTO findByID(Long id) {
       CountMoney find= countMoneyRepo.findById(id).get();
        return CountMoneyMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<CountMoneyDTO> findAll() {
        List<CountMoney> salary= countMoneyRepo.findAll();
        return CountMoneyMapper.INSTANCE.toDTOList(salary);
    }
    @Override
    public void delete(Long id) {
countMoneyRepo.deleteById(id);
    }
/* public  Double calculateSalary(CountMoneyDTO countMoneyDTO,Double dailyRate){
LocalDate startPresentDay=countMoneyDTO.getEmployPresentDayStart();
LocalDate endPresentDay=countMoneyDTO.getEmployPresentDayEnd();
LocalDate startApsentDay=countMoneyDTO.getApsentDaysOfEmployStart();
LocalDate endApsentDay=countMoneyDTO.getApsentDaysOfEmloyEnd();
long daysPresent= ChronoUnit.DAYS.between(startPresentDay,endPresentDay);
long daysApsent=ChronoUnit.DAYS.between(startApsentDay,endApsentDay);
Double salary=calculateSalaryWithAbsentDays(daysPresent,daysApsent,dailyRate);
countMoneyDTO.setAppsentDay((int)daysApsent);

    countMoneyDTO.setSalary(salary);
    return salary;
    }
    private Double calculateSalaryWithAbsentDays(long daysPresent, long daysApsent, Double dailyRate) {
        daysPresent -= daysApsent;
        return daysPresent * dailyRate;
    }*/
}
