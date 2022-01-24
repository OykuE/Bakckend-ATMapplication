package atmapplication.business.concretes;

import atmapplication.business.abstracts.CardService;
import atmapplication.dataAccess.CardDao;
import atmapplication.entities.concretes.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardManager implements CardService {

    @Autowired
    CardDao cardDao;

    @Override
    public Card getCard(int userId) {

        if (cardDao.getByUserId(userId).isPresent()) {
            return cardDao.getByUserId(userId).get();
        }
        return null;
    }
}
