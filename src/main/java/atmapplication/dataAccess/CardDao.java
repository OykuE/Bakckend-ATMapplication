package atmapplication.dataAccess;

import atmapplication.entities.concretes.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDao extends JpaRepository<Card, Integer> {
}
