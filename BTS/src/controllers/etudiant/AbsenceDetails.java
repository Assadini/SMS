package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.classe.AnneeScolaire;
import Domaine.etudiant.AbsenceEtudiant;
import dao.classe.AnneeScolaireDAO;
import dao.etudiant.AbsenceDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/Absence/Details")
public class AbsenceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AbsenceDAO absenceDAO;
    public AbsenceDetails() {
        super();
        absenceDAO = new AbsenceDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json=null;
		int id =Integer.parseInt(request.getParameter("id"));
		AbsenceEtudiant absence= new AbsenceEtudiant();
		try {
			
			absence = absenceDAO.getById(id);
			ObjectMapper om=new ObjectMapper();
			System.out.println(absence);
			json =om.writeValueAsString(absence);
			System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
