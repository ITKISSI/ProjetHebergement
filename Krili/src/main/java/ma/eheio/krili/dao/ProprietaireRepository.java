package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Client;
import ma.eheio.krili.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {

    public Proprietaire findProprietaireByEmailAndPassword(String email,String password);
}
