package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository  extends JpaRepository<Annonce,Long> {
}
