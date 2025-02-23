package controllers.classe;

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

import Domaine.classe.Classe;
import dao.classe.ClasseDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/ClassebyFil/List")
public class ClasseListbyf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseDAO classeDAO;
    public ClasseListbyf() {
        super();
        classeDAO = new ClasseDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Classe> classes;
		int id =Integer.parseInt(request.getParameter("id"));
		String json=null;
		try {
			classes = classeDAO.getByfil(id);
			json = new Gson().toJson(classes);
			
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
