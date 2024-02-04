package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode (exclude = {"produto"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString (exclude = {"produto"})
@Entity
public class HistoricoPreco implements Serializable {

    @NonNull
    @EmbeddedId
    private HistoricoPrecoId historicoPrecoId;
    //@Id
    //private Timestamp DataAct;

    @NonNull
    @Column(nullable = false)
    private Double valor;

    @NonNull
    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

}
