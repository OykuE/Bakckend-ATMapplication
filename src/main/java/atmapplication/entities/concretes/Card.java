package atmapplication.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue
    @Column(name="card_id")
    private int cardId;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="user_id")
    private int userId;

    @Column(name="cvv")
    private String cvv;

    @Column(name="card_type")
    private String cardType;

}
