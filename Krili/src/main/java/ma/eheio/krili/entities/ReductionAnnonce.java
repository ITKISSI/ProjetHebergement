package ma.eheio.krili.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReductionAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reduction;


    @NotBlank(message = "Date_debut est obligatoire")
    private Date Date_debut;

    @NotBlank(message = "Date_fin est obligatoire")
    private Date Date_fin;
}
