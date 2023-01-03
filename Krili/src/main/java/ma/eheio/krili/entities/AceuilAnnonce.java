package ma.eheio.krili.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


public class AceuilAnnonce {


    private Long id_announce;
    private String adress;
    private String titre;
    private double prix;

    public AceuilAnnonce(){}
    public AceuilAnnonce(Long id_announce, String adress, String titre, double prix) {
        this.id_announce = id_announce;
        this.adress = adress;
        this.titre = titre;
        this.prix = prix;
    }


    public Long getId_announce() {
        return id_announce;
    }

    public void setId_announce(Long id_announce) {
        this.id_announce = id_announce;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
