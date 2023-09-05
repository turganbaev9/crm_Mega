package kg.mega.crm_mega.service.impl;

import kg.mega.crm_mega.mapper.MentorMapper;
import kg.mega.crm_mega.model.Mentor;
import kg.mega.crm_mega.model.dto.MentorDTO;
import kg.mega.crm_mega.repository.MentorRepo;
import kg.mega.crm_mega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {
 private final MentorRepo mentorRepo;
    @Override
    public MentorDTO saveMentor(MentorDTO mentorDTO) {
  Mentor mentor=MentorMapper.INSTANCE.toEntity(mentorDTO);
  mentorRepo.save(mentor);
  return  MentorMapper.INSTANCE.toDTO(mentor);
    }

    @Override
    public MentorDTO update(MentorDTO mentorDTO) {
        Mentor existingMentor=mentorRepo.findById(mentorDTO.getId()).
                orElseThrow(()->new EntityNotFoundException("Mentor with ID"+
                        mentorDTO.getId()+"not found"));
if (mentorDTO.getCourse()!=null){
    existingMentor.setCourse(mentorDTO.getCourse());
}
if (mentorDTO.getSurname()!=null){
    existingMentor.setSurname(mentorDTO.getSurname());
}
if (mentorDTO.getName()!=null){
    existingMentor.setName(mentorDTO.getName());
}if (mentorDTO.getCourseFormat()!=null){
    existingMentor.setCourseFormat(mentorDTO.getCourseFormat());
        }
Mentor updatedMentor=mentorRepo.save(existingMentor);
        return MentorMapper.INSTANCE.toDTO(updatedMentor);
    }

    @Override
    public MentorDTO findById(Long id) {
 Mentor find=mentorRepo.findById(id).get();
 return MentorMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<MentorDTO> findAllMentors() {
        List<Mentor> mentors = mentorRepo.findAll();
     return    MentorMapper.INSTANCE.toDTOList(mentors);

    }
    @Override
    public void deleteMentor(Long id) {
mentorRepo.deleteById(id);
    }
}
