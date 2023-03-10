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
    @Column(length = 10000)
    @NotBlank(message = "Titre est obligatoire")
    private String Titre;

    @NotBlank(message = "Localisation est obligatoire")
    @Column(length = 10000)
    private String Localisation;

    @Column(length = 10000)
    @NotBlank(message = "Adress est obligatoire")
    private String Adress;

    @Column(length = 10000)
    @NotBlank(message = "Description est obligatoire")
    private String Description ;
    @Column(length = 25)
    @NotBlank(message = "Capacite est obligatoire")
    private int Capacite;
    @Column(length = 25)
    @NotBlank(message = "Prix est obligatoire")
    private double Prix;

    @OneToMany
    private Collection<Reservation> reservations;
    @ManyToOne
    private Proprietaire proprietaire;

    @ManyToOne
    private TypeAnnonce typeAnnonces;

    @OneToMany
    private Collection<ReductionAnnonce> reductionAnnonces;

    @OneToMany (mappedBy = "annonce" , fetch = FetchType.EAGER)
    private Collection<Image> images;

}
