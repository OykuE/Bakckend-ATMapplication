package atmapplication.business.concretes;

import atmapplication.business.abstracts.UserService;
import atmapplication.dataAccess.UserDao;
import atmapplication.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User login(String tckNo, String password) {
        if(userDao.findByTcknoandPassword(tckNo,password).isPresent()){
            return userDao.findByTcknoandPassword(tckNo,password).get();
        }
        return null;
    }

    @Override
    public User getUser(int userId) {
       if(userDao.findById(userId).isPresent()){
        return userDao.findById(userId).get();
       }
       return null;
    }
}
