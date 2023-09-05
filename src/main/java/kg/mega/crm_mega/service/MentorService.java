package kg.mega.crm_mega.service;

import kg.mega.crm_mega.model.dto.MentorDTO;

import java.util.List;

public interface MentorService {
    MentorDTO saveMentor(MentorDTO mentorDTO);
    MentorDTO update(MentorDTO mentorDTO);
    MentorDTO findById(Long id);
    List<MentorDTO> findAllMentors();
    void  deleteMentor(Long id);
}
