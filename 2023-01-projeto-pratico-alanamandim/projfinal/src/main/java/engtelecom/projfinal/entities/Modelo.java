package engtelecom.projfinal.entities;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode (exclude = {"produtos", "maquinas"})
@ToString (exclude = {"produtos", "maquinas"})
@Entity
public class Modelo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModelo;
    @NonNull
    @Column(nullable = false)
    private String modelo;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Produto> produtos = new HashSet<>();

    @OneToMany(mappedBy = "modelo")
    public Set<Maquina>maquinas = new HashSet<>();


}
