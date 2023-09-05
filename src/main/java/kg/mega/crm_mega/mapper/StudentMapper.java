package kg.mega.crm_mega.mapper;

import kg.mega.crm_mega.model.Students;
import kg.mega.crm_mega.model.dto.StudentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
StudentMapper INSTANCE= Mappers.getMapper(StudentMapper.class);
Students toEntity(StudentsDTO studentsDTO);
StudentsDTO  toDTO(Students students);
List<Students>toEntityList(List<StudentsDTO>studentsDTOList);
List<StudentsDTO>toDTOList(List<Students> studentsList);
}
