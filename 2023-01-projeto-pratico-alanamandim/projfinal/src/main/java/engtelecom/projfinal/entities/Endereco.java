package engtelecom.projfinal.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode(exclude = {"locais"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"locais"})
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @NonNull
    @Column(nullable = false)
    private String nome;
    @NonNull
    @Column(nullable = false)
    private String ruaNr;

    @NonNull
    @Column(nullable = false)
    private String bairro;

    @NonNull
    @Column(nullable = false)
    private String cidade;

    @NonNull
    @Column(nullable = false)
    private String estado;

    @NonNull
    @Column(nullable = false)
    private Integer cep;

    @OneToMany(mappedBy = "endereco")
    private Set<Local> locais;


}
