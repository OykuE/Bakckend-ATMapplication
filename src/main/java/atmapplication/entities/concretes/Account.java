package atmapplication.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue
    @Column(name="account_id")
    private int accountId;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="user_id")
    private int userId;

    @Column(name="balance")
    private double balance;

    @Column(name="account_type")
    private String accountType;
}
