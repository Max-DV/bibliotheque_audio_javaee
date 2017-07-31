package fr.sopra.pox3.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sopra.pox3.ejb.AuteurDAO;
import fr.sopra.pox3.entities.Auteur;

@WebServlet ("/index.html")
public class JPA101 extends HttpServlet{

	@EJB
	private AuteurDAO auteurDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("i am here" );
		
		Auteur auteur= new Auteur();
		auteur.setNom("Toto");
		
		auteurDAO.ajouterAuteur(auteur);
		//auteurDAO.updateAuteur(auteur);
		//auteurDAO.deleteAuteur(auteur);
		//auteurDAO.findAll(id);
		
		auteur= auteurDAO.findById(1);
		auteur.setNom("Il est " + new Date());
		auteurDAO.updateAuteur(auteur);
		
		List<Auteur> auteurs= auteurDAO.findAll();
		for (Auteur a : auteurs){
			resp.getWriter().println(a.getId()+ " => " + a.getNom());
		}
	}
}
