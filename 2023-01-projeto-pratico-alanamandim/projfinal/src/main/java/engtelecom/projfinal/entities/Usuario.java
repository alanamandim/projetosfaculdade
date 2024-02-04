package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode (exclude = {"titular", "consumo", "dependente"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString (exclude = {"titular", "consumo", "dependente"})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @NonNull
    private String cpf;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private String senha;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String telefone;

    //criar relacionamento onetoone com titular

//    @OneToOne(mappedBy = "idtitular", cascade = CascadeType.ALL)
//    private Titular titular;

    // @OneToOne(mappedBy = "cpf", cascade = CascadeType.ALL)
    // private Titular titular;

//    // criar relacionamento onetoone com dependente
//    @OneToOne(mappedBy = "iddependente", cascade = CascadeType.ALL)
//    private Dependente dependente;

    //criar relacionamento onetomany com consumo
    @OneToMany(mappedBy = "idUsuario")
    private Set<Consumo> consumo = new HashSet<>();

}
