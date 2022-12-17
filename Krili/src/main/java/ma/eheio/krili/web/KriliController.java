package ma.eheio.krili.web;

import ma.eheio.krili.dao.AnnonceRepository;
import ma.eheio.krili.dao.ReservationRepository;
import ma.eheio.krili.entities.Annonce;
import ma.eheio.krili.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class KriliController {
    private ReservationRepository reservationRepository;
    private AnnonceRepository annonceRepository;
    @RequestMapping(value="/index",method= RequestMethod.GET)

    public String consulterAnnounce(Model model , @RequestParam(name="page",defaultValue = "0")int p, @RequestParam(name="size",defaultValue = "10")int s) {


        Page<Reservation> pageReservations= reservationRepository.findAll(PageRequest.of(p, s)) ;

        model.addAttribute("listReservations",pageReservations.getContent());

        int[] pages= new int[pageReservations.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);

        return "index";															 //       page de reservation +profile + Filtre_annonce..
    }

    @RequestMapping(value="/reservation",method=RequestMethod.POST)

    public String reserver(Model model ) {

        model.addAttribute("reservation",new Reservation());
        return "FormReservation";

    }

    @RequestMapping(value = "/save",method=RequestMethod.POST)

    public String save(Model model, @Validated Reservation reservation, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())return "FormReservation";

        reservationRepository.save(reservation);

        return "Confirmation";
    }

    @RequestMapping(value="/annonce/reservation",method=RequestMethod.POST)

    public String Annuler(Long id_reservation ) {
        reservationRepository.deleteById(id_reservation);
        return "redirect:/annonce";

    }

    //*******************************Proprietaire action ******************************************

    // ajouter une Annonce

    @RequestMapping(value="/FormAnnonce",method=RequestMethod.POST)
    public String AddAnnonce(Model model ) {

        model.addAttribute("annonce",new Annonce());
        return "FormAnnonce";                                                            // retourne Formulaire d'annonce

    }

    // Suprimer une annonce
    @RequestMapping(value="/MesAnnonce/suprimer",method=RequestMethod.POST)
    public String suprimer(Long id_annonce ) {
        reservationRepository.deleteById(id_annonce);
        return "redirect:/MesAnnonce";                  							// retourne  page des annonce fait par le Proprietaire

    }

    // Editer une annonce
    @RequestMapping(value="/annonce",method=RequestMethod.POST)
    public String updateAnnonce(Long id_annonce ) {
        reservationRepository.findById(id_annonce);
        return "redirect:/FormAnnonce";

    }

    // ajouter une reduction
    @RequestMapping(value="/reduction",method=RequestMethod.POST)
    public String AddReductionAnnonce(Model model   ) {

        model.addAttribute("reduction",new Annonce().getId_announce());
        return "FormReduction";                                                   // retuorne Formulaire de reduction

    }


    // Suprimer une reduction
    @RequestMapping(value="/MesAnnonce",method=RequestMethod.POST)
    public String suprimerReservation(Long id_annonce ) {
        reservationRepository.deleteById(id_annonce);
        return "redirect:/MesAnnonce";
    }


    // Editer une annonce
    /*  ******************  Code erroné ************************************

    @RequestMapping(value="/FormAnnonce",method=RequestMethod.POST)
    public String updateReduction(Long id_reduction ) {
        reservationRepository.findById(id_reduction);
        return "redirect:/FormAnnonce";

    }
    */


    // insertion d'images par Proprietaire

    @GetMapping("/insert_image")
    public String insetAnnonce(Model model){
        model.addAttribute("addAnnonce",new Annonce());

        return   "insert_image";                                // retourne  la page d'insertion d'image
    }


    /*
    @PostMapping("/FormAnnonce")
    public String postAnnonce(@ModelAttribute("addAnnonce")@Validated Annonce annonce, BindingResult result, Model model ,@RequestParam("imagefile") MultipartFile file, @RequestParam("unitid") long id_announce) throws IOException {
        annonceRepository.save(annonce);
        long id=annonce.getId_announce();
        Optional<Annonce> u=annonceRepository.findById(id);
          UnitOfMeasure ob=unitOfMeasureRepository.findById(id_announce);
        Byte[] byteObjects = convertToBytes(file); // we have to convert it to Byte[] array
        u.setImage(byteObjects);
        annonceRepository.save(u); // TODO refactor - save once
        return "redirect:/FormAnnonce/insert_image";
    }

    private Byte[] convertToBytes(MultipartFile file) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }
        return byteObjects;
    }
*/



}