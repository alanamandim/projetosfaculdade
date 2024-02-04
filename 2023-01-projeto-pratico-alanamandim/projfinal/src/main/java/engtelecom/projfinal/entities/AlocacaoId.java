package engtelecom.projfinal.entities;


import lombok.*;

import java.io.Serializable;

import java.sql.Timestamp;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlocacaoId implements Serializable {
    private LocalId idLocal;
    private Integer idMaquina;
    private Timestamp dataEntrada;
}
