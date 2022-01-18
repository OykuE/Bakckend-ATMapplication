package atmapplication.business.abstracts;

import atmapplication.entities.concretes.User;



public interface UserService {
User login(String tckNo, String password);
User getUser(int userId);
}
