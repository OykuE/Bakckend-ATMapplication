package atmapplication.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayOffDebtDto {
    private int userId;
    private String cardType;
    private String accountType;
    private double payoff;
}
