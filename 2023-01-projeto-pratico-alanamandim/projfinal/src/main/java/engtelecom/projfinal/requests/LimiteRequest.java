package engtelecom.projfinal.requests;

import lombok.Data;

@Data
public class LimiteRequest {
    private String idTitular;
    private String idDependente;
    private Double limite;
}
