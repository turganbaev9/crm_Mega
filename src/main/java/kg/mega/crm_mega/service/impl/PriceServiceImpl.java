package kg.mega.crm_mega.service.impl;

import kg.mega.crm_mega.mapper.PriceMapper;
import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.Students;
import kg.mega.crm_mega.model.dto.PriceDTO;
import kg.mega.crm_mega.repository.PriceRepo;
import kg.mega.crm_mega.repository.StudentRepo;
import kg.mega.crm_mega.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private  final PriceRepo priceRepo;
    private final StudentRepo studentRepo;
    @Override
    public PriceDTO savePrice(PriceDTO priceDTO) {
        Price price = PriceMapper.INSTANCE.toEntity(priceDTO);
        Students students = studentRepo.findById(priceDTO.getStudents().getId())
                .orElseThrow(() -> new NoSuchElementException("Student with this id not found" + priceDTO.getStudents().getId()));
        price.setStudents(students);
     calcPayStudent(price);
        priceRepo.save(price);
        return PriceMapper.INSTANCE.toDTO(price);
    }

public void calcPayStudent(Price price){
        Double payd=price.getPaid();
        Double priceValue=price.getPrice();
        Double duration=priceValue-payd;
price.setLeftSum(duration);

}

    @Override
    public PriceDTO update(PriceDTO priceDTO) {
        Price price=PriceMapper.INSTANCE.toEntity(priceDTO);
        Price update=priceRepo.findById(price.getId()).get();
        update.setCourse(price.getCourse());

        update.setCourseFormat(price.getCourseFormat());
        update.setPaid(price.getPaid());
        update.setPrice(price.getPrice());
        return PriceMapper.INSTANCE.toDTO(update);
    }

    @Override
    public PriceDTO finById(Long id) {
      Price find=priceRepo.findById(id).get();

        return PriceMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<PriceDTO> findAll() {
        List<Price>prices=priceRepo.findAll();

        return PriceMapper.INSTANCE.toDTOList(prices);
    }

    @Override
    public void deletePrice(Long id) {
priceRepo.deleteById(id);
    }
}
