package ma.eheio.krili.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TypeAnnonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_typeAnnonce;

    @NotBlank(message = "Libelle est obligatoire")
    @Column(length = 30)
    private String Libelle;

    @ManyToOne
    private Annonce annonce;


}
