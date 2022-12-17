package ma.eheio.krili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KriliApplication {

    public static void main(String[] args) {
        SpringApplication.run(KriliApplication.class, args);
        System.out.println("hello");
    }

}
