package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
