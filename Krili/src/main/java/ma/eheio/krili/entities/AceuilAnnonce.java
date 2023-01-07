package ma.eheio.krili.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class AceuilAnnonce {

     @Column(name = "id_announce")
    private Long id_announce;
    @Column(name = "adress")
    private String adress;
    @Column(name = "titre")
    private String titre;
    @Column(name = "prix")
    private double prix;
    @Column(name = "photo_annonce")
    private String photo_annonce;


}
