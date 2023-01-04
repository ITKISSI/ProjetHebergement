package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Annonce;
import ma.eheio.krili.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    public Client findByEmailAndPassword(String email, String password);

    public Client save(Client client);


}
