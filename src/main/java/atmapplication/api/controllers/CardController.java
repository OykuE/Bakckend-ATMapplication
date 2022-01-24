package atmapplication.api.controllers;

import atmapplication.business.abstracts.CardService;
import atmapplication.entities.concretes.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        super();
        this.cardService = cardService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Card> getUser(@PathVariable int userId){
        return ResponseEntity.ok(cardService.getCard(userId));
    }
}