package kg.mega.crm_mega.controller;

import kg.mega.crm_mega.model.dto.MentorDTO;
import kg.mega.crm_mega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
        ("/api/v1/mentor")
@RequiredArgsConstructor
public class MentorController {
    private final MentorService mentorService;
@PostMapping("/saveMentor")
 public MentorDTO saveMentor(@RequestBody MentorDTO mentorDTO){
    return mentorService.saveMentor(mentorDTO);
}
@PutMapping("/updateMentor/{id}")
public ResponseEntity<MentorDTO> updateMentor(@PathVariable("id")Long id,@RequestBody MentorDTO mentorDTO) {
    MentorDTO existMentor = mentorService.findById(id);
    if (existMentor == null) {
        ResponseEntity.notFound().build();
    }
    mentorDTO.setId(id);
    MentorDTO updated = mentorService.update(mentorDTO);
    return ResponseEntity.ok(updated);

}
@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable("id")Long id){
    MentorDTO mentorDTO=mentorService.findById(id);
    if (mentorDTO==null){
        ResponseEntity.notFound().build();
    } else if (mentorDTO!=null) {
        mentorService.deleteMentor(id);
        ResponseEntity.ok();

    }else
mentorService.deleteMentor(id);
    return ResponseEntity.noContent().build();
}
@GetMapping("/findById")
    public MentorDTO findById(Long id){
    MentorDTO mentorDTO=mentorService.findById(id);
    return mentorDTO;
}
        @GetMapping("/findAll")
    public List<MentorDTO> mentorDTOS(){
    return mentorService.findAllMentors();
        }
}
