package atmapplication.dataAccess;

import atmapplication.entities.concretes.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardDao extends JpaRepository<Card, Integer> {
    Optional<Card> getByUserId(int userId);
    Optional<Card> findByUserIdAndCardType(int userId, String cardType);
}
