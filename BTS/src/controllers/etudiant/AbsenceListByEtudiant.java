package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet("/AbsenceByEtudiant/List")
public class AbsenceListByEtudiant extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AbsenceDAO absencedao;
	public AbsenceListByEtudiant() {
		absencedao=new AbsenceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<AbsenceEtudiant> absetd=null;
	int id =Integer.parseInt(request.getParameter("id"));
	try {
		

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
		absetd=AbsenceDAO.getAllByEtd(id);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper om=new ObjectMapper();
		System.out.println(absetd);
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
	