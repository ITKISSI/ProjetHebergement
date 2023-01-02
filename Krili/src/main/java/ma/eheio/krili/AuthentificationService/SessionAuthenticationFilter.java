package ma.eheio.krili.AuthentificationService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.eheio.krili.dao.ClientRepository;
import ma.eheio.krili.dao.ProprietaireRepository;
import ma.eheio.krili.entities.Proprietaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@Order(Ordered.HIGHEST_PRECEDENCE)

public class SessionAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    ProprietaireRepository proprietaireRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path= request.getRequestURI();
        if(path.startsWith("/css/")){
            filterChain.doFilter(request, response);
        }

        //////////////////////////////////////////

        HttpSession session = request.getSession(false);
        int idProprietaire = 0;
        int idClient = 0;
        if(session != null) {
            if(session.getAttribute("id") != null) {
                idProprietaire = (int) session.getAttribute("id");
            }
            if(session.getAttribute("idClient") != null) {
                idClient = (int) session.getAttribute("idClient");
            }
        }

        if (idProprietaire != 0 || request.getRequestURI().equals("/Login_proprietaire")) {

            filterChain.doFilter(request, response);

        } else if(idClient != 0 || request.getRequestURI().equals("/Login_Client")){
            String getpath =request.getRequestURI();
            if(!path.startsWith("/Proprietaire"))
            {
                filterChain.doFilter(request, response);
            }else {
                response.sendRedirect("/Login_proprietaire");
            }
        }
        else {
            response.sendRedirect("/Login_Client");
        }

    }
}
