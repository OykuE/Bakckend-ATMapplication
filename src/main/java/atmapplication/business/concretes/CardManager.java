package atmapplication.business.concretes;

import atmapplication.business.abstracts.AccountService;
import atmapplication.business.abstracts.CardService;
import atmapplication.dataAccess.CardDao;
import atmapplication.entities.concretes.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardManager implements CardService {

    @Autowired
    CardDao cardDao;


    private AccountService accountService;

    public CardManager(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Card getCard(int userId) {

        if (cardDao.getByUserId(userId).isPresent()) {
            return cardDao.getByUserId(userId).get();
        }
        return null;
    }

    @Override
    public Card cards(int userId, String cardType) {
        if(cardDao.findByUserIdAndCardType(userId,cardType).isPresent()){
            return cardDao.findByUserIdAndCardType(userId,cardType).get();
        }
        return null;
    }

    @Override
    public Integer payOffDebt(int userId, String cardType, String accountType, double payoff) {
        if(cardDao.findByUserIdAndCardType(userId,cardType).isPresent()){
            Card card = cardDao.findByUserIdAndCardType(userId,cardType).get();
            card.setDebt((card.getDebt())-payoff);
            cardDao.save(card);
            accountService.withdraw(userId,accountType,payoff);
            return 1;
        }
        return -1;
    }

}
