package kg.mega.crm_mega.service;


import kg.mega.crm_mega.model.dto.StudentsDTO;

import java.util.List;

public interface StudentService {
StudentsDTO saveStudent(StudentsDTO studentsDTO);

StudentsDTO update(StudentsDTO studentsDTO);

StudentsDTO findByID(Long id);


    List<StudentsDTO> findAll();
    void deleteSalary(Long id);

}
