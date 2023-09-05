package kg.mega.crm_mega.mapper;

import kg.mega.crm_mega.model.Mentor;
import kg.mega.crm_mega.model.dto.MentorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MentorMapper {
MentorMapper INSTANCE= Mappers.getMapper(MentorMapper.class);
Mentor toEntity(MentorDTO mentorDTO);
MentorDTO toDTO(Mentor mentor);
List<Mentor> toEntityList(List<MentorDTO >mentorDTOList);
List<MentorDTO> toDTOList(List<Mentor> mentorList);
}
