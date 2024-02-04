package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"cartaoPref", "titular"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"titular","cartaoPref"})
@Entity
public class Cartoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCartao;

    @NonNull
    @Column(nullable = false)
    private String validade;

    @NonNull
    @Column(nullable = false)
    private String numero;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private Integer codSeg;

    @NonNull
    @ManyToOne
   // @MapsId("idTitular")
   // @JoinColumn(name = "id_titular", nullable = false)
    private Titular titular;

    @OneToOne(mappedBy = "cartaoPref", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Titular cartaoPref;
}
