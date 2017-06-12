package controlleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;

/**
 * Servlet implementation class AddCategorie
 */
public class AddCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String categorie=request.getParameter("nom_categorie");
	try{
	ContactDAO c=new ContactDAO();
	c.AddCategorie(categorie);
    response.sendRedirect("AddCategorie.jsp");

	}catch(Exception e)
	{
		System.out.println("e="+e.getMessage());
		}

}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
