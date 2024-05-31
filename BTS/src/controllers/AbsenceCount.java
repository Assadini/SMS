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
import dao.etudiant.AbsenceDAO;

@WebServlet("/Absence/Count")
public class AbsenceCount  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AbsenceDAO absencedao; 
	public AbsenceCount() {
		absencedao=new AbsenceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<AbsenceEtudiant>abs;
	try {
		abs=AbsenceDAO.getNbreAbs();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper om=new ObjectMapper();
		String json = om.writeValueAsString(abs);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

}