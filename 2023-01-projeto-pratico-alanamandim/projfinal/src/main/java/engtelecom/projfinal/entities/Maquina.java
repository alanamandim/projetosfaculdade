package engtelecom.projfinal.entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

import java.io.Serializable;
import java.util.HashSet;

@Getter
@Setter
@EqualsAndHashCode (exclude = {"alocacoes","modelo", "consumos"})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString (exclude = {"alocacoes","modelo", "consumos"})
@Entity
public class Maquina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaquina;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "idMaquina", fetch = FetchType.EAGER)
    private Set<Alocacao> alocacoes =  new HashSet<>();

    @NonNull
    @ManyToOne
    @MapsId("idModelo")
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @OneToMany(mappedBy = "maquina")
    private Set<Consumo> consumos;


}
