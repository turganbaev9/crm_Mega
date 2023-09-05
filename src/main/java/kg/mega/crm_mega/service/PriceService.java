package kg.mega.crm_mega.service;

import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO savePrice(PriceDTO price);

    PriceDTO update(PriceDTO priceDTO);

    PriceDTO finById(Long id);

    List<PriceDTO> findAll();

    void deletePrice(Long id);
}