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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;
    @NotBlank(message = "Date_entree est obligatoire")
    private Date Date_entree;
    @NotBlank(message = "Date_sortie est obligatoire")
    private Date Date_sortie;
    @NotBlank(message = "Nbr_personnes est obligatoire")
    private int Nbr_personnes;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Annonce annonce;

}
