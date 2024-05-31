package controllers.classe;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.classe.Classe;

import Domaine.classe.Filiere;
import Domaine.emploiDuTemps.SeanceGenerique;
import Domaine.etudiant.AbsenceEtudiant;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.matiere.Periode;
import Domaine.personnel.Professeur;

import dao.classe.ClasseDAO;

import dao.classe.FiliereDAO;
import dao.etudiant.AbsenceDAO;
import dao.classe.EmploiSeanceGenerique;
import dao.matiere.MatiereDAO;
import dao.matiere.ModuleDAO;
import util.ServerResponse;
@WebServlet("/Emplois/List")
public class EmploisList extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private EmploiSeanceGenerique emploi;
		 public EmploisList() {
		        super();
		       emploi = new EmploiSeanceGenerique();
		    }

			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id =Integer.parseInt(request.getParameter("id"));
				ArrayList<SeanceGenerique> emplois= new ArrayList();
			
				String json=null;
				try {
					emplois = emploi.getAll(id);
					System.out.println(emplois);
					json = new ObjectMapper().writeValueAsString(emplois);
					System.out.println(json);
					
				} catch (SQLException e) {
					json = new Gson().toJson(e.getMessage()).toString();
					e.printStackTrace();
				}
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
			}
		}
	