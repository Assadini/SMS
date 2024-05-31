package controllers.etudiant;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Domaine.etudiant.AbsenceEtudiant;
import Domaine.etudiant.Statistiques;
import dao.etudiant.AbsenceDAO;

@WebServlet("/Absence/Stats")
public class AbsenceStats  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AbsenceDAO absencedao; 
	public AbsenceStats() {
		absencedao=new AbsenceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<Statistiques>abs;
	try {
		abs= AbsenceDAO.getEtdStatistiques();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper om=new ObjectMapper();
		String json = om.writeValueAsString(abs);
		PrintWriter out = response.getWriter();
		System.out.println(json);
		out.println(json);
		out.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

}
