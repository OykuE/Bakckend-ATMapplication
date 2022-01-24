package atmapplication.business.abstracts;

import atmapplication.entities.concretes.Account;

public interface AccountService {
Account accounts(int userId, String accountType);
Integer withdraw(int userId, String accountType, double withdraw);
Integer deposit(int userId, String accountType, double deposit);
}
