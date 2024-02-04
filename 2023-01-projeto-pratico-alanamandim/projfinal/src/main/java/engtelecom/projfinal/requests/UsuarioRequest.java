package engtelecom.projfinal.requests;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String idUsuario;
    private String nome;
    private String senha;
    private String email;
    private String telefone;
    private String nomeCar;
    private String validade;
    private String numCartao;
    private Integer codSeg;
    private Integer datapagamento;

}
