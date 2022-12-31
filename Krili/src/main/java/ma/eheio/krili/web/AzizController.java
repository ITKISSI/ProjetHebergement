package ma.eheio.krili.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AzizController  {
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }

}
