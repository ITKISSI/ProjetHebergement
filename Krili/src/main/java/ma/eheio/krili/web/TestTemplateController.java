package ma.eheio.krili.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestTemplateController {

    @RequestMapping("/ahmed")
    public String index()
    {
        return "Acceuil";
    }
}
