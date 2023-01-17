package ma.eheio.krili.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ma.eheio.krili.dao.*;
import ma.eheio.krili.entities.*;

import ma.eheio.krili.dao.AnnonceRepository;
import ma.eheio.krili.dao.ImageRepository;
import ma.eheio.krili.dao.ReservationRepository;
import ma.eheio.krili.entities.Annonce;
import ma.eheio.krili.entities.Image;
import ma.eheio.krili.entities.Reservation;
import ma.eheio.krili.metier.IAnnonceReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import java.util.Map;
import java.util.Optional;


@Controller
public class KriliController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;


    @Autowired
    private IAnnonceReservation dao;
    @RequestMapping("/AnnonceDetails")
    public String Annonne()
    {
        return "AnnonceDetails";
    }
    @RequestMapping("/Login_Client")
    public String loginClient(@ModelAttribute Client client)
    {

        return "ClientLogin";
    }
    @PostMapping("/Login_Client")
    public String loginClient(HttpServletRequest request, @ModelAttribute Client client, Model model)
    {
        Client client1=clientRepository.findByEmailAndPassword(client.getEmail(),client.getPassword());
        if(client1 == null) {

            model.addAttribute("erreur", "login ou mot de passe incorrect");
            return "ClientLogin";
        }
        else {

            HttpSession session= request.getSession(true);
            session.setAttribute("id",client1.getId_Client());
            session.setAttribute("nom",client1.getNom());
            return "redirect:/Acceuil";
        }
    }
    @RequestMapping("/Login_proprietaire")
    public String loginProprietaire(@ModelAttribute Proprietaire proprietaire)
    {
        return "ProprietaireLogin";
    }
    @PostMapping("/Login_proprietaire")
    public String loginProprietaire(HttpServletRequest request, @ModelAttribute Proprietaire proprietaire, Model model)
    {
        Proprietaire proprietaire1 =proprietaireRepository.findProprietaireByEmailAndPassword(proprietaire.getEmail(),proprietaire.getPassword());
        if(proprietaire1 == null) {
            model.addAttribute("erreur", "login ou mot de passe incorrect");
            return "ProprietaireLogin";
        }
        else {
            HttpSession session= request.getSession(true);
            session.setAttribute("id",proprietaire1.getId_Proprietaire());
            return "redirect:/Acceuil";
        }
    }
    @RequestMapping(value={"/", "/Acceuil"},method= RequestMethod.GET)
    public String consulterAnnounce(Model model , @RequestParam(name = "page",defaultValue = "0") int page,
                                    @RequestParam(name = "size",defaultValue = "2") int size) {

        Page<Annonce> annonceList = annonceRepository.findAll(PageRequest.of(page, size));

        model.addAttribute("AnnonceList", annonceList.getContent());
        int[] pages = new int[annonceList.getTotalPages()];
        model.addAttribute("pages", pages);

        return "Acceuil";                                                             //       page de reservation +profile + Filtre_annonce..
    }
    @GetMapping("/ahmed")
    public String Test(Model model){
       /*List<AceuilAnnonce> annonce1=annonceRepository.AnnonceImage();
       model.addAttribute("annonce",annonce1);*/
        return "test";
    }

    @RequestMapping("/Annonce/Details")
    public String Update(Model model,Long id)
    {
        Annonce annonces=annonceRepository.DetailsAnonce(id);
        /*List<Image> images=imageRepository.findImageByAnnonce(1L);        model.addAttribute("image",images);*/
        model.addAttribute("a",annonces);

        return "AnnonceDetails";
    }

    @RequestMapping(value = "Annonce/reservation")

    public  String Reservation(Model model,Long id){
        Annonce annonces=annonceRepository.DetailsAnonce(id);
        model.addAttribute("Annonce",annonces);
        return "Reservation";
    }
    @PostMapping(value = "/Annonce/Reservation")
    public String Reservation(Model model,Reservation reservation)
    {

        dao.reserver(reservation);
        return "redirect:/Acceuil";
    }

    @RequestMapping(value="/reservation",method=RequestMethod.POST)

    public String reserver(Model model )
    {
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


    /************ upload images  *******************/

    @PostMapping("/upload")
    public String handleImageUpload(@RequestParam("image") List<MultipartFile> images)
    {
        for (MultipartFile image : images) {
            Image img = new Image();
            //img.setData(image.getBytes());
            imageRepository.save(img);
        }
        return "redirect:/images";
    }

    @GetMapping("/images")
    public String showImages(Model model) {
        List<Image> images = imageRepository.findAll();
        model.addAttribute("images", images);
        return "images";
    }
    
    /* view de telechargement image
            <div th:each="image : ${images}">
            <img th:src="'data:image/png;base64,' + ${image.data}" />
            </div>

     */




}
