package giocattolandia.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class Toys {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "productName")
    @NotNull
    @NotBlank
    private String productName;

    @Column(name ="stockQuantity")
    private int stockQuantity;

    @Column(name ="avaragePrice")
    private BigDecimal avaragePrice;

    @Column(name ="actualPrice")
    private BigDecimal actualPrice;

    @Column(name ="barCode")
    private Long barCode;

    @Column(name ="immediateAvaiability")
    private boolean immediateAvaiability = false;
}
