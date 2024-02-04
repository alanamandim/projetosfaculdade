package engtelecom.projfinal.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ConsumoId implements Serializable {
    private String idUsuario;
    private Timestamp dataAct;
}
