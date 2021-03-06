package atmapplication.api.controllers;

import atmapplication.api.dto.CardsDto;
import atmapplication.api.dto.PayOffDebtDto;
import atmapplication.business.abstracts.CardService;
import atmapplication.entities.concretes.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/cards")
    public ResponseEntity<Card> cards(@RequestBody CardsDto cardsDto){
        return ResponseEntity.ok(cardService.cards(cardsDto.getUserId(),cardsDto.getCardType()));
    }


   @PutMapping("/pay-off-dept")
    public ResponseEntity<Integer> payOffDebt(@RequestBody PayOffDebtDto payOffDebtDto){
        return ResponseEntity.ok(cardService.payOffDebt(payOffDebtDto.getUserId(),payOffDebtDto.getCardType(),payOffDebtDto.getAccountType(),payOffDebtDto.getPayoff()));
   }


}
