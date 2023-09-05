package kg.mega.crm_mega.controller;

import kg.mega.crm_mega.model.dto.StudentsDTO;
import kg.mega.crm_mega.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
   private final StudentService studentService;
   @PostMapping("/saveStudent")
   public StudentsDTO save(@RequestBody StudentsDTO studentsDTO){
       return studentService.saveStudent(studentsDTO);
   }
   @PutMapping("/updateStudent/{id}")
   public ResponseEntity<StudentsDTO> update(@PathVariable ("id")Long id,@RequestBody StudentsDTO studentsDTO){
       StudentsDTO exist=studentService.findByID(id);
       if (exist==null){
           ResponseEntity.notFound().build();
       }
       studentsDTO.setId(id);
       StudentsDTO update=studentService.update(studentsDTO);
       return ResponseEntity.ok(update);
   }
   @DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deleteStudent(@PathVariable ("id")Long id){
       StudentsDTO studentsDTO=studentService.findByID(id);
   if (studentsDTO==null){
       ResponseEntity.notFound().build();
   } else if (studentsDTO!=null) {
       studentService.deleteSalary(id);
       ResponseEntity.ok();
   }else studentService.deleteSalary(id);
  return ResponseEntity.noContent().build();
   }
   @GetMapping("/findById")
    public  StudentsDTO findById(Long id){
       StudentsDTO studentsDTO=studentService.findByID(id);
       return studentsDTO;
   }
   @GetMapping("/findAll")
    public List<StudentsDTO>studentsDTOS(){
       return studentService.findAll();
   }
}
