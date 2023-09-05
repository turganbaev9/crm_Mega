package kg.mega.crm_mega.repository;

import kg.mega.crm_mega.model.CountMoney;
import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountMoneyRepo extends JpaRepository<CountMoney,Long> {
Optional<CountMoney>findByPrice(Price price);


}
