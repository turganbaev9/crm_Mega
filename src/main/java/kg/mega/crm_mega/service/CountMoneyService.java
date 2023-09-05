package kg.mega.crm_mega.service;

import kg.mega.crm_mega.model.CountMoney;
import kg.mega.crm_mega.model.dto.CountMoneyDTO;

import java.util.List;

public interface CountMoneyService {
    CountMoneyDTO save(CountMoneyDTO countMoneyDTO);
    CountMoneyDTO update(CountMoneyDTO countMoneyDTO);
    CountMoneyDTO findByID(Long id);
    List<CountMoneyDTO>findAll();
    void delete(Long id);
}
