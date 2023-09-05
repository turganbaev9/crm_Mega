package kg.mega.crm_mega.controller;

import kg.mega.crm_mega.model.dto.CountMoneyDTO;
import kg.mega.crm_mega.service.CountMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/count")
@RequiredArgsConstructor
public class CountMoneyController {
  private final CountMoneyService countMoneyService;
    @PostMapping("saveCount")
    public CountMoneyDTO save(@RequestBody CountMoneyDTO countMoneyDTO){
      return countMoneyService.save(countMoneyDTO);
   }
   @PutMapping("updateCount/{id}")
    public ResponseEntity<CountMoneyDTO> update(@PathVariable ("id")Long id,@RequestBody CountMoneyDTO countMoneyDTO){
        CountMoneyDTO exist=countMoneyService.findByID(id);
        if (exist==null){
            ResponseEntity.notFound().build();
        }
        countMoneyDTO.setId(id);
        CountMoneyDTO update=countMoneyService.update(countMoneyDTO);
        return ResponseEntity.ok(update);
   }
@DeleteMapping("delete/{id}")
public ResponseEntity<Void>delete(@PathVariable("id")Long id){
    CountMoneyDTO countMoneyDTO=countMoneyService.findByID(id);
    if (countMoneyDTO==null){
    ResponseEntity.notFound().build();
    } else if (countMoneyDTO!=null) {
        countMoneyService.delete(id);
    ResponseEntity.ok();
    }else countMoneyService.delete(id);
    return ResponseEntity.noContent().build();

}
@GetMapping("/findById")
    public CountMoneyDTO findById(Long id){
        CountMoneyDTO countMoneyDTO=countMoneyService.findByID(id);
        return countMoneyDTO;
}
@GetMapping("/findAll")
    public List<CountMoneyDTO>countMoneyDTOS(){
        return countMoneyService.findAll();
}
}
