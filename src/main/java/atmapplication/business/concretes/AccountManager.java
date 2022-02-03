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

    @Override
    public Double withdraw(int userId, String accountType, double withdraw) {
        if(accountDao.findByUserIdAndAccountType(userId,accountType).isPresent()){
            Account account = accountDao.findByUserIdAndAccountType(userId,accountType).get();
            if(account.getBalance() - withdraw < 0) {
                return Double.valueOf(-2);
            } else {
                account.setBalance((account.getBalance())-withdraw);
                accountDao.save(account);
                return account.getBalance();
            }

        }
        return Double.valueOf(-1);
    }

    @Override
    public Double deposit(int userId, String accountType, double deposit) {
        if(accountDao.findByUserIdAndAccountType(userId,accountType).isPresent()){
            Account account = accountDao.findByUserIdAndAccountType(userId,accountType).get();
            account.setBalance((account.getBalance())+deposit);
            accountDao.save(account);
            return account.getBalance();
        }
        return Double.valueOf(-1);
    }
}
