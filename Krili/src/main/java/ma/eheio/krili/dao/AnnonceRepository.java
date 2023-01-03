package ma.eheio.krili.dao;

import ma.eheio.krili.entities.AceuilAnnonce;
import ma.eheio.krili.entities.Annonce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface AnnonceRepository  extends JpaRepository<Annonce,Long>
{
    @Transactional
    @Query("SELECT a FROM Annonce a  where  a.id_announce = :idAnnonce")
    public Annonce DetailsAnonce(@Param("idAnnonce") Long idAnnonce);

    @Query(value = "select DISTINCT p1.id_announce,p1.adress,p1.titre,p1.prix ,(SELECT i.image from image i where i.annonce_id_announce=p1.id_announce limit 1) as photo_annonce from image i1 inner join annonce p1 ON i1.annonce_id_announce=p1.id_announce ",nativeQuery = true)
    public  List<AceuilAnnonce>  AnnonceImage();
}
