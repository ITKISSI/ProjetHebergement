package ma.eheio.krili.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id_Client;
    @Column(length = 25)
    @NotBlank(message = "Nom est obligatoire")
    private String Nom;
    @NotBlank(message = "Prenom est obligatoire")
    @Column(length = 25)
    private String Prenom;
    @NotBlank(message = "Adress est obligatoire")
    private String Adress;
    @Column(length = 25)
    @NotBlank(message = "Password est obligatoire")

    private String Password;
    @NotBlank(message = "NO_passport est obligatoire")
    @Column(length = 30)
    private String NO_passport;
    @NotBlank(message = "Pays est obligatoire")
    @Column(length = 25)
    private String Pays;
    @NotBlank(message = "Telephone est obligatoire")
    @Column(length = 25)
    private String Telephone;

    @ManyToOne
    private Collection<Reservation> reservations;

}
