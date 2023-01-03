package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Annonce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnnonceRepository  extends JpaRepository<Annonce,Long>
{
    @Transactional
    @Query("SELECT a FROM Annonce a  where  a.id_announce = :idAnnonce")
    public Annonce DetailsAnonce(
            @Param("idAnnonce") Long idAnnonce
    );
}
