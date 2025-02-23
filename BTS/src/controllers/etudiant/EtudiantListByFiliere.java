package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Domaine.etudiant.Etudiant;
import dao.etudiant.EtudiantDAO;

@WebServlet("/EtudiantByclass/List")
public class EtudiantListByFiliere extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO;
    public EtudiantListByFiliere() {
        super();
        etudiantDAO = new EtudiantDAO();
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Etudiant> etudiants= new ArrayList<Etudiant>();
		String json = null;
		int id =Integer.parseInt(request.getParameter("id"));
		try {
			etudiants = etudiantDAO.getByclasse(id);
			/*
			 * Important : En raison d'un probl�me de reflectvit� du champs Date h�rit� de la classe Utilisateur
			 * J'ai d� utiliser l'API Jackson au lieu de l'API Gson.
			 * Pr�voir peut etre de changer l'API Gson par Jackson dans tout le projet
			 */
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(etudiants);
			json = mapper.writeValueAsString(etudiants);
			System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}



}
