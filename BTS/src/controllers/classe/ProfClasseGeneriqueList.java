package controllers.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.classe.AnneeScolaireCourante;
import Domaine.classe.Classe;
import Domaine.classe.ClasseGenerique;
import Domaine.evaluation.Soutenance;
import dao.classe.AnneeScolaireCouranteDAO;
import dao.classe.ClasseDAO;
import dao.classe.ClasseGeneriqueDAO;

@WebServlet("/ProfClasseGeneriqueList")
public class ProfClasseGeneriqueList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseDAO classeDAO;
    public ProfClasseGeneriqueList() {
        super();
        classeDAO = new ClasseDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Classe> classes= new ArrayList<Classe>();


		try {
			// System.out.println(anne);
		   
			//int id =Integer.parseInt(request.getParameter("id"));
			//System.out.println(id);
//			if(id==0) {
//				userID =  (Integer) session.getAttribute("userID");
//			}else {
//				userID=id;
//			}
		    
		    classes = classeDAO.getAllclassbyprof(7);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(classes).toString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
