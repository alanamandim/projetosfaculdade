package engtelecom.projfinal.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@ToString( exclude = { "iddependente","titular"})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Dependente extends Usuario implements Serializable {


    @NonNull
    @ManyToOne
   // @MapsId("idTitular")
   // @JoinColumn(name = "id_titular", nullable = false)
    private Titular titular;

    @NonNull
    @Column(nullable = false)
    private double limiteMensal;

    @NonNull
    @Column(nullable = false)
    private double saldo;

    public Dependente(@NonNull String cpf, @NonNull String nome, @NonNull String senha, @NonNull String email, @NonNull String telefone) {
        super(cpf, nome, senha, email, telefone);
    }
}
