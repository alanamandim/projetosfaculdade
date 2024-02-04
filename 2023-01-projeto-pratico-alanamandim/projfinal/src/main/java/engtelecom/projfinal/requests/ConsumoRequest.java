package engtelecom.projfinal.requests;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ConsumoRequest {
    private String idUsuario;
    private Integer idProduto;
    private Integer idMaquina;
}
