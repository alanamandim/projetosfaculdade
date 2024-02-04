package engtelecom.projfinal.requests;

import lombok.Data;

@Data
public class AlocacaoRequest {
    private Integer idMaquina;
    private Integer idLocal;
    private Integer idEndereco;
}
