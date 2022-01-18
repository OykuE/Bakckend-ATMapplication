package atmapplication.dataAccess;

import atmapplication.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@NoRepositoryBean
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByTcknoandPassword(String tckNo, String password);

    Optional<User> findById(int userId);
}
