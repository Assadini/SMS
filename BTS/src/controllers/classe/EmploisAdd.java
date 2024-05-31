package controllers.classe;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.classe.Classe;

import Domaine.classe.Filiere;
import Domaine.emploiDuTemps.SeanceGenerique;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.matiere.Periode;
import Domaine.personnel.Professeur;

import dao.classe.ClasseDAO;

import dao.classe.FiliereDAO;

import dao.classe.EmploiSeanceGenerique;
import dao.matiere.MatiereDAO;
import dao.matiere.ModuleDAO;
import util.ServerResponse;
@WebServlet("/Emploi/Add")
public class EmploisAdd extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private EmploiSeanceGenerique sg;
		 public EmploisAdd() {
		        super();
		       sg = new EmploiSeanceGenerique();
		    }
		 public void init(ServletConfig config) throws ServletException {
				// TODO Auto-generated method stub
			}

			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				
				int classeid=Integer.parseInt(request.getParameter("classe"));
				int proffeseurId=Integer.parseInt(request.getParameter("prof"));
				int matiereId=Integer.parseInt(request.getParameter("matiere"));
				int moduleId=Integer.parseInt(request.getParameter("module"));
				int salleId=Integer.parseInt(request.getParameter("salle"));
				int periodeId=Integer.parseInt(request.getParameter("periode"));
				String jour=request.getParameter("jour");
				int duree=Integer.parseInt(request.getParameter("duree"));
				String debut=request.getParameter("heuredeb");
				String fin=request.getParameter("heurefin");
				String ob=request.getParameter("observation");
				String message=null;
				boolean success =false;
				
				try {
					   
					SeanceGenerique seanceToAdd = new  SeanceGenerique();
					seanceToAdd.setJour(jour);
					seanceToAdd.setHeureDebut(debut);
					seanceToAdd.setHeureFin(fin);
					seanceToAdd.setDuree((short)duree);
					seanceToAdd.setObservation(ob);
					
					
				    Classe classe= new Classe();
				    classe.setId(classeid);
				    seanceToAdd.setClasse( classe);
				    
					
					Professeur prof=new Professeur();
					prof.setId(proffeseurId);
					seanceToAdd.setProfesseur(prof);
					
					Matiere mat =new Matiere();
					mat.setId(matiereId);
					seanceToAdd.setMatiere(mat);
					
					Module Mod=new Module();
					Mod.setId(moduleId);
					seanceToAdd.setModule(Mod);
					
					Salle salle=new Salle(); 
					salle.setId(salleId);
					seanceToAdd.setSalle(salle);
					
					Periode periode =new Periode();
					periode.setId(periodeId);
					seanceToAdd.setPeriode(periode);
					
			    
			       sg.insert(seanceToAdd);
			      
			       success =true;
				
				
				
				
				
				}
				
				
				 catch (SQLException e1) {
							success=false;
							message="Impossible d'ajouter la seance "+e1;
							e1.printStackTrace();
					}
						ServerResponse serverResponse = new ServerResponse(success,message);
						
						Gson gson = new GsonBuilder().create();
					    String json = gson.toJson(serverResponse);
					    System.out.println(json );
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						out.print(json);
						out.flush();
					
					
					}

					
					
					
					
					
				
				
				
				
				
				
			
}
