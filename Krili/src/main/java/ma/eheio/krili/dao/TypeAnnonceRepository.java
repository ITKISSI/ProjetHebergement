package ma.eheio.krili.dao;

import ma.eheio.krili.entities.TypeAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAnnonceRepository extends JpaRepository<TypeAnnonce,Long> {
}
