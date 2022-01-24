package atmapplication.business.abstracts;

import atmapplication.entities.concretes.Account;

public interface AccountService {
Account accounts(int userId, String accountType);
}
