package kg.mega.crm_mega.controller;

import kg.mega.crm_mega.model.dto.PriceDTO;
import kg.mega.crm_mega.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@RequiredArgsConstructor
public class PriceController {
private final PriceService priceService;
@PostMapping("/savePrice")
    public PriceDTO savePrice(@RequestBody PriceDTO priceDTO){
    return priceService.savePrice(priceDTO);
}
@PutMapping("/updatePrice/{id}")
    public ResponseEntity<PriceDTO> updatePrice(@PathVariable("id")Long id,@RequestBody PriceDTO priceDTO){
    PriceDTO exist=priceService.finById(id);
    if (exist==null){
        ResponseEntity.notFound().build();
    }
    priceDTO.setId(id);
    PriceDTO  updated=priceService.update(priceDTO);
    return ResponseEntity.ok(updated);
}
@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable ("id")Long id){
    PriceDTO priceDTO=priceService.finById(id);
    if (priceDTO==null){
        ResponseEntity.notFound().build();
    }
    else if(priceDTO!=null){
        priceService.deletePrice(id);
        ResponseEntity.ok();
    }
    else priceService.deletePrice(id);
    return ResponseEntity.noContent().build();
}
@GetMapping("/findById")
    public PriceDTO findById( Long id){
    PriceDTO priceDTO=priceService.finById(id);
    return priceDTO;
}
@GetMapping("/findAll")
    public List<PriceDTO> priceDTOS(){
    return priceService.findAll();
}

}
