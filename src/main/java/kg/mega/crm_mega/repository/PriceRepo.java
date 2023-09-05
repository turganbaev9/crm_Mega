package kg.mega.crm_mega.repository;

import kg.mega.crm_mega.model.Price;
import kg.mega.crm_mega.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    //Optional<Price> findByStudents(List<Students> students);
}
