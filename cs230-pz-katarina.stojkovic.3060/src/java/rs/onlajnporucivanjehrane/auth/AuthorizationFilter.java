package rs.onlajnporucivanjehrane.auth;

import java.io.IOException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rs.onlajnporucivanjehrane.entities.User;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/faces/jelo/*", "/faces/porudzbine/*", "/faces/restoran/*", "/faces/user/*"})
public class AuthorizationFilter implements Filter {

    @Inject
    Login loginBean;

    @PersistenceContext(unitName = "cs230-pz-katarina.stojkovic.3060PU")
    private EntityManager em;

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest reqt = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession ses = (HttpSession) reqt.getSession(false);

        User user = null;
        try {
            user = (User) em.createNamedQuery("User.findByUsername").setParameter("username", loginBean.getUsername()).getSingleResult();
           
            String reqURI = reqt.getRequestURI();

            if (user.getRole().getNazivRole().equals("ADMIN")
                    && (reqURI.contains("/jelo/")
                    || reqURI.contains("/porudzbine/")
                    || reqURI.contains("/restoran/")
                    || reqURI.contains("/user/"))) {
                chain.doFilter(request, response);
            } else if (user.getRole().getNazivRole().equals("VLASNIK")
                    && reqURI.contains("/drustvo/")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
            }
        } catch (NoResultException e) {
            resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
        }
    }

    @Override
    public void destroy() {
    }
}
