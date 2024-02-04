package engtelecom.projfinal.requests;

import lombok.Data;

@Data
public class DependenteRequest {
        private String idUsuario;
        private String idTitular;
        private String nome;
        private String senha;
        private String email;
        private String telefone;
        private double limite;
        private double saldo;

}
