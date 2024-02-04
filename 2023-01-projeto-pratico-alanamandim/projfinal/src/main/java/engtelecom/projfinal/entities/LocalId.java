package engtelecom.projfinal.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class LocalId implements Serializable {
    private Integer local;
    private Integer idEndereco;
}
