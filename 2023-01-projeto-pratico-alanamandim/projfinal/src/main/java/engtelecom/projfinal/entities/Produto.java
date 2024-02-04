package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"modelos","historicoPreco","consumos"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"modelos","historicoPreco","consumos"})
@Entity
public class Produto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @ManyToMany(mappedBy = "produtos", fetch = FetchType.EAGER)
    private Set<Modelo> modelos = new HashSet<>();

    @OneToMany(mappedBy = "produto",fetch = FetchType.EAGER)
    private Set<HistoricoPreco> historicoPrecos = new HashSet<>();

    @OneToMany(mappedBy = "produto",fetch = FetchType.EAGER)
    private Set<Consumo> consumos  = new HashSet<>();


}
