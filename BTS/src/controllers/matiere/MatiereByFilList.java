package controllers.matiere;

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

	import Domaine.matiere.Matiere;

	import dao.matiere.MatiereDAO;

	/**
	 * Servlet implementation class MatiereList
	 */
	@WebServlet("/MatiereByFil/List")
	
public class MatiereByFilList extends HttpServlet{
	
		private static final long serialVersionUID = 1L;
		private MatiereDAO matiereDAO;
	    public MatiereByFilList() {
	        super();
	        matiereDAO = new MatiereDAO();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<Matiere> matieres= new ArrayList<Matiere>();
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				matieres = matiereDAO.getByFiliere(id);
				ObjectMapper om = new ObjectMapper();
				System.out.println(matieres);

				String json = om.writeValueAsString(matieres);
				System.out.println(matieres);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}



