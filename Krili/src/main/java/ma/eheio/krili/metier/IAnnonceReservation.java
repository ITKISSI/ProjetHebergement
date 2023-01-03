package ma.eheio.krili.metier;

import lombok.Data;
import ma.eheio.krili.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.Date;

@Repository
public interface IAnnonceReservation  {

    public void  reserver (Reservation reservation);
}
