package ma.eheio.krili;

import ma.eheio.krili.dao.TypeAnnonceRepository;
import ma.eheio.krili.entities.Annonce;
import ma.eheio.krili.entities.TypeAnnonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KriliApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(KriliApplication.class, args);



        /*String date1 ="01-Jan-2017";
        String date2 = "02-Feb-2017";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        LocalDate d1 = LocalDate.parse(date1, df);
        LocalDate  d2 = LocalDate.parse(date2, df);

        Long datediff = ChronoUnit.DAYS.between(d1,d2);
        System.out.println("hello");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-dd-yyyy");
        formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse("3-24-2022", formatter);
        System.out.println(date.getDayOfMonth());

        LocalDate date2 = LocalDate.parse("3-27-2022", formatter);
        System.out.println(date.getDayOfMonth());

        double prix=date2.getDayOfMonth() - date.getDayOfMonth();
        System.out.println(prix);*/

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
