package kg.mega.crm_mega.mapper;

import kg.mega.crm_mega.model.CountMoney;

import kg.mega.crm_mega.model.dto.CountMoneyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountMoneyMapper {
CountMoneyMapper INSTANCE= Mappers.getMapper(CountMoneyMapper.class);
CountMoney toEntity(CountMoneyDTO countMoneyDTO);
CountMoneyDTO toDTO(CountMoney countMoney);
List<CountMoney>toEntityList(List<CountMoneyDTO> countMoneyDTOSDTO);
List<CountMoneyDTO>toDTOList(List<CountMoney>countMonies);
}
