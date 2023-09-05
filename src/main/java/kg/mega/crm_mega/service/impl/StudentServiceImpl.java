package kg.mega.crm_mega.service.impl;

import kg.mega.crm_mega.mapper.StudentMapper;
import kg.mega.crm_mega.model.Students;
import kg.mega.crm_mega.model.dto.StudentsDTO;
import kg.mega.crm_mega.repository.StudentRepo;
import kg.mega.crm_mega.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
     private final StudentRepo studentRepo;
    @Override
    public StudentsDTO saveStudent(StudentsDTO studentsDTO) {
        Students students= StudentMapper.INSTANCE.toEntity(studentsDTO);
        studentRepo.save(students);
        return StudentMapper.INSTANCE.toDTO(students);
    }

    @Override
    public StudentsDTO update(StudentsDTO studentsDTO) {
        Students existingSt=studentRepo.findById(studentsDTO.getId()).orElseThrow(()->new EntityNotFoundException("Student with this Id"+studentsDTO.getId()+"not found"));
        Optional.ofNullable(studentsDTO.getCourse()).ifPresent(existingSt::setCourse);
        Optional.ofNullable(studentsDTO.getCourseFormat()).ifPresent(existingSt::setCourseFormat);
        Optional.ofNullable(studentsDTO.getBirthData()).ifPresent(existingSt::setBirthData);
    Optional.ofNullable(studentsDTO.getName()).ifPresent(existingSt::setName);
    Optional.ofNullable(studentsDTO.getSurname()).ifPresent(existingSt::setSurname);
    Optional.ofNullable(studentsDTO.isMarried()).ifPresent(existingSt::setMarried);
    Students update=studentRepo.save(existingSt);
    return StudentMapper.INSTANCE.toDTO(update);}

    @Override
    public StudentsDTO findByID(Long id) {
        Students find=studentRepo.findById(id).get();
        return StudentMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<StudentsDTO> findAll() {
        List<Students>students=studentRepo.findAll();
        return StudentMapper.INSTANCE.toDTOList(students);
    }

    @Override
    public void deleteSalary(Long id) {
studentRepo.deleteById(id);
    }

}
