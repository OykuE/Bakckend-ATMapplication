package atmapplication.entities.concretes;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer userId;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="tck_number")
    private String tckNo;

    @Column(name="password")
    private String password;

    @Column(name="debt")
    private double debt;
}
