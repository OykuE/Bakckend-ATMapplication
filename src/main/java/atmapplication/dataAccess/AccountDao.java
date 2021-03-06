package atmapplication.dataAccess;

import atmapplication.entities.concretes.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends JpaRepository<Account,Integer> {
    Optional<Account> findByUserIdAndAccountType(int userId, String accountType);
}
