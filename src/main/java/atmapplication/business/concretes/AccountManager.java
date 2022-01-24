package atmapplication.business.concretes;

import atmapplication.business.abstracts.AccountService;
import atmapplication.dataAccess.AccountDao;
import atmapplication.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManager implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account accounts(int userId, String accountType) {
        if(accountDao.findByUserIdAndAccountType(userId, accountType).isPresent()){
            return accountDao.findByUserIdAndAccountType(userId,accountType).get();
        }
        return null;
    }
}
