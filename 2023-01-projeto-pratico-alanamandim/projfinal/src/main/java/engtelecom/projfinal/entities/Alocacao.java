package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode (exclude = {"local", "maquina"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"local", "maquina"})
@IdClass(AlocacaoId.class)
@Entity
public class Alocacao {

   // @EmbeddedId
   // private AlocacaoId idAlocacao;

    private Timestamp dataSai;

    @Id
    private Timestamp dataEntrada;

    @Id
    @NonNull
    @ManyToOne( fetch = FetchType.EAGER)
    private Local idLocal;

    @Id
    @NonNull
    @ManyToOne( fetch = FetchType.EAGER)
    private Maquina idMaquina;

    public Alocacao(Timestamp dataEntrada, @NonNull Local idLocal, @NonNull Maquina idMaquina) {
        this.dataEntrada = dataEntrada;
        this.idLocal = idLocal;
        this.idMaquina = idMaquina;
    }
}

