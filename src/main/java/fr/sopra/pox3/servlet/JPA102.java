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
import fr.sopra.pox3.ejb.MaisonDeDisqueDAO;
import fr.sopra.pox3.entities.Auteur;
import fr.sopra.pox3.entities.MaisonDeDisque;

@WebServlet("/index2.html")
public class JPA102 extends HttpServlet {

	@EJB
	private AuteurDAO auteurDAO;
	
	@EJB
	private MaisonDeDisqueDAO maisonDeDisqueDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("i am here");

		/*
		MaisonDeDisque maison = new MaisonDeDisque();
		maison.setId(322);

		Auteur auteur = new Auteur();
		auteur.setNom("Toto");
		auteur.setMaison(maison);

		auteurDAO.ajouterAuteur(auteur);*/
		
		MaisonDeDisque maison= maisonDeDisqueDAO.findById(322);
		System.out.println(maison.getNom());
		System.out.println(maison.getId());
		System.out.println(maison.getAuteurs().size());

	}
}
