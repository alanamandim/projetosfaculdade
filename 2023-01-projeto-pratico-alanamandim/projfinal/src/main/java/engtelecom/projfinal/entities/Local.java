package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode (exclude = {"alocacoes", "endereco"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString ( exclude = {"endereco","alocacoes"})
@Entity
public class Local implements Serializable {
    @NonNull
    @EmbeddedId
    private LocalId idLocal;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @ManyToOne
    @MapsId("idEndereco")
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @NonNull
    @OneToMany(mappedBy = "idLocal", fetch = FetchType.EAGER)
    private Set<Alocacao> alocacoes = new HashSet<>();

//    public Local(@NonNull LocalId idLocal, @NonNull String nome) {
//        this.idLocal = idLocal;
//        this.nome = nome;
//    }
}

