package atmapplication.business.abstracts;

import atmapplication.entities.concretes.Card;

public interface CardService {
    Card getCard(int userId);
    Card cards(int userId, String cardType);
    Integer payOffDebt(int userId, String cardType, String accountType,double payoff);
}
