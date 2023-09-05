package kg.mega.crm_mega.repository;

import kg.mega.crm_mega.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<Mentor,Long> {

}
