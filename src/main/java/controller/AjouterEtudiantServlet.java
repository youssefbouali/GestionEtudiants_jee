package controller;

import java.io.IOException;
//import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouterEtudiantServlet
 */
public class AjouterEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		if(request.getParameter("submit") != null) {

			String nom = request.getParameter("nom").trim();
	        String prenom = request.getParameter("prenom").trim();
	        String email = request.getParameter("email").trim();
	        
			if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty()) {
	
		        Etudiant Et = new Etudiant(nom, prenom, email);
	
				EtudiantDao EtDao = new EtudiantDao();
				EtDao.addEtudiant(Et);
	
	
		        response.sendRedirect("ListeEtudiantsServlet");

			} else {
				response.getWriter().append("Empty Inputs");
			}
		}

	}

}
