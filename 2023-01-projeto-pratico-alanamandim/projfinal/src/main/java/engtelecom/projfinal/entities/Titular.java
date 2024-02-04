package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude ={"cartoes", "dependentes"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"cartoes", "dependentes"})
@Entity
@PrimaryKeyJoinColumn(name = "cpf")
public class Titular extends Usuario implements Serializable {

    @OneToMany(mappedBy = "titular")
    private Set<Cartoes> cartoes = new HashSet<>();

    @OneToMany(mappedBy = "titular")
    private Set<Dependente> dependentes = new HashSet<>();

    @OneToOne(optional = true)
    private Cartoes cartaoPref;

    @NonNull
    @Column(nullable = false)
    private int diaPagamento;

    public Titular(@NonNull String cpf, @NonNull String nome, @NonNull String senha, @NonNull String email, @NonNull String telefone) {
        super(cpf, nome, senha, email, telefone);
    }
}
