package atmapplication.business.abstracts;

import atmapplication.entities.concretes.Card;

public interface CardService {
    Card getCard(int userId);
}
