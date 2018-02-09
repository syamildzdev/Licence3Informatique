package servlet;

import facade.GestionQCM;
import facade.QCMImpl;
import modele.Questionnaire;
import modele.exceptions.InformationsSaisiesIncoherentesException;
import modele.exceptions.UtilisateurDejaConnecteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class Controleur extends HttpServlet {

    private GestionQCM facade;

    @Override
    public void init() throws ServletException{
        facade = new QCMImpl();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        PrintWriter out = response.getWriter();
        out.println("<html><title>un qcm</title><body>");

        if (action == null) {
            action = "login";
        }

        switch (action) {
            case "login":
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                break;
            case "connect":
                String login = request.getParameter("login");
                String password = request.getParameter("password");

                try {
                    facade.connexion(login, password);
                    // login
                    request.getSession(true).setAttribute("pseudo", login);
                    request.getRequestDispatcher("/WEB-INF/view/menu.jsp").forward(request, response);
                } catch(UtilisateurDejaConnecteException e) {
                    request.getRequestDispatcher("/WEB-INF/view/menu.jsp").forward(request, response);
                } catch (InformationsSaisiesIncoherentesException e){
                    request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
                }
                break;
            case "choixQCM":
                login = (String)request.getSession(true).getAttribute("currentuser");
                Collection<Questionnaire> listeQcm = facade.getListQuestionnairesNonFaits(login);
                request.setAttribute("listeQcm",listeQcm);
                request.getRequestDispatcher("/WEB-INF/view/choixQCM.jsp").forward(request, response);
                break;
            case "lancerQcm":
                login = (String)request.getSession().getAttribute("pseudo");
                //int idQuestionnaire = Integer.valueOf(((Questionnaire)request.getSession().getAttribute("idQuestionnaire")));
                int idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
                //String reponse = "";
                //facade.validerQuestion(login,idQuestion,reponse);
                break;

            default:
                break;

        }

    }

}
