package atmapplication.business.abstracts;

import atmapplication.entities.concretes.Account;

public interface AccountService {
Account accounts(int userId, String accountType);
Double withdraw(int userId, String accountType, double withdraw);
Double deposit(int userId, String accountType, double deposit);
}
