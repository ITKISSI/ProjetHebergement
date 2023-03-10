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
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Proprietaire;

    @Column(length = 25)
    @NotBlank(message = "Nom est obligatoire")
    private String Nom;

    @Column(length = 25)
    @NotBlank(message = "Prenom est obligatoire")
    private String Prenom;

    @NotBlank(message = "email est obligatoire")
    private String email;


    private String Adress;

    @Column(length = 25)
    @NotBlank(message = "Password est obligatoire")
    private String password;

    @Column(length = 25)

    private String NO_passport;

    @Column(length = 25)

    private String Pays;

    @Column(length = 25)
    @NotBlank(message = "Telephone est obligatoire")
    private String Telephone;


    private String No_patent;

    @OneToMany
    private Collection<Annonce> annonce;


}
