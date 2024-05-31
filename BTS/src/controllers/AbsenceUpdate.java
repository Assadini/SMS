package controllers.etudiant;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.sql.SQLException;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.classe.Filiere;
import Domaine.etablissement.Etablissement;
import Domaine.etudiant.AbsenceEtudiant;
import Domaine.etudiant.Etudiant;
import Domaine.etudiant.Mention;
import Domaine.etudiant.OptionBac;
import Domaine.etudiant.Parent;
import Domaine.securite.Compte;
import Domaine.securite.Role;

import com.google.gson.Gson;

import dao.etudiant.AbsenceDAO;
import dao.etudiant.EtudiantDAO;
import dao.etudiant.ParentDAO;
import dao.securite.CompteDAO;
import dao.securite.RoleDAO;
import dao.utilisateur.UtilisateurDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Absence/Update")
public class AbsenceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDAO utilisateurDAO;
    private EtudiantDAO etudiantDAO;
    private ParentDAO parentDAO;
    public AbsenceUpdate() {
        super();
        utilisateurDAO = new UtilisateurDAO();
        etudiantDAO = new EtudiantDAO();
        parentDAO = new ParentDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("tagagvt");
		 request.setCharacterEncoding("UTF-8");
		 AbsenceEtudiant absenceetudiant=new AbsenceEtudiant();
		 absenceetudiant.setJustification(true);
		 absenceetudiant.setMotif(request.getParameter("motif"));
		 absenceetudiant.setId(Integer.parseInt(request.getParameter("id")));
		String result=null;	
		try {
			
			AbsenceDAO.update(absenceetudiant);
	
			result="L'�Absence � �t� modifi� avec succ�s";
		} catch (SQLException e) {
			result="Impossible de modifier l'�tudiant";
			e.printStackTrace();
		}
		
		String json = new Gson().toJson(result).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
}
