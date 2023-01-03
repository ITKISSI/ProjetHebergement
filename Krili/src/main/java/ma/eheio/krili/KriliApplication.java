package ma.eheio.krili;

import ma.eheio.krili.metier.AnnonceReservationImpl;
import ma.eheio.krili.metier.IAnnonceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@SpringBootApplication
public class KriliApplication {


    public static void main(String[] args) {
        SpringApplication.run(KriliApplication.class, args);



        /*String date1 ="01-Jan-2017";
        String date2 = "02-Feb-2017";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        LocalDate d1 = LocalDate.parse(date1, df);
        LocalDate  d2 = LocalDate.parse(date2, df);

        Long datediff = ChronoUnit.DAYS.between(d1,d2);
        System.out.println("hello");*/

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-dd-yyyy");
        formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse("3-24-2022", formatter);
        System.out.println(date.getDayOfMonth());

        LocalDate date2 = LocalDate.parse("3-27-2022", formatter);
        System.out.println(date.getDayOfMonth());

        double prix=date2.getDayOfMonth() - date.getDayOfMonth();
        System.out.println(prix);

    }

}
