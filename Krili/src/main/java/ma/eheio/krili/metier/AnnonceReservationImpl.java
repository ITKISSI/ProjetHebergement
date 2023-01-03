package ma.eheio.krili.metier;

import ma.eheio.krili.dao.AnnonceRepository;
import ma.eheio.krili.dao.ReservationRepository;
import ma.eheio.krili.entities.Annonce;
import ma.eheio.krili.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnnonceReservationImpl implements IAnnonceReservation {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AnnonceRepository annonceRepository;

    @Override
    public void reserver(Reservation reservation)
    {
        Long idAnnonce= reservation.getAnnonce().getId_announce();
        Optional<Annonce> annonce=annonceRepository.findById(Long.valueOf(idAnnonce));
        double prixAnnonce= annonce.get().getPrix();
        int jr1=reservation.getDate_entree().getDate();
        int jr2=reservation.getDate_sortie().getDate();
        double montantPayer=(jr2-jr1)*prixAnnonce;
        reservation.setMontantPayer(montantPayer);
        reservationRepository.save(reservation);
    }
}
