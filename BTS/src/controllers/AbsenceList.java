package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.etudiant.AbsenceEtudiant;
import dao.etudiant.AbsenceDAO;



/**
 * Servlet implementation class AbsenceListe
 */
@WebServlet("/Absence/List")
public class AbsenceList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AbsenceDAO absencedao; 
	public AbsenceList() {
		absencedao=new AbsenceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<AbsenceEtudiant> absetd=null;
	/*String json=null;
	
	try {
		absetd = absencedao.getAlletd();
		System.out.println(absetd);
		json = new Gson().toJson(absetd);
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
	*/
	try {
		absetd=AbsenceDAO.getAlletd();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper om=new ObjectMapper();
		String json = om.writeValueAsString(absetd);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
	