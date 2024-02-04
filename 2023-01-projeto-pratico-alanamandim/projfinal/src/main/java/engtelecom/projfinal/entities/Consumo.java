package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"idUsuario"})
@Entity
public class Consumo implements Serializable {

    @NonNull
    @EmbeddedId
    private ConsumoId idConsumo;

    @NonNull
    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_maquina", nullable = false)
    private Maquina maquina;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;





}
