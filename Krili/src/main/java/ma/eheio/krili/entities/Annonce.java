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
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_announce;
    @Column(length = 25)
    @NotBlank(message = "Titre est obligatoire")
    private String Titre;

    @NotBlank(message = "Adress est obligatoire")
    private String Localisation;

    @NotBlank(message = "Adress est obligatoire")
    private String Adress;

    @NotBlank(message = "Description est obligatoire")
    private String Description ;
    @Column(length = 25)
    @NotBlank(message = "Prix est obligatoire")
    private int Capacite;
    @Column(length = 25)
    @NotBlank(message = "Prix est obligatoire")
    private double Prix;

    @NotBlank(message = "image est obligatoire")
    private Byte[] image;

    @OneToMany
    private Collection<Reservation> reservations;
    @ManyToOne
    private Proprietaire proprietaire;

    @OneToMany
    private Collection<TypeAnnonce> typeAnnonces;

    @OneToMany
    private Collection<ReductionAnnonce> reductionAnnonces;
}
