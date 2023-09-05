package kg.mega.crm_mega.mapper;

import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
PriceMapper INSTANCE= Mappers.getMapper(PriceMapper.class);
Price toEntity(PriceDTO priceDTO);
PriceDTO toDTO(Price price);
List<Price>toEntityList(List<PriceDTO >priceDTOList);
List<PriceDTO>toDTOList(List<Price>priceList);

}
