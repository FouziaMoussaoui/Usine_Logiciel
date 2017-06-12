package controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String num_tel = request.getParameter("num_tel");
		String type_tel= request.getParameter("type_tel");
		int categorie= Integer.parseInt(request.getParameter("categorie"));
		int idContact= Integer.parseInt(request.getParameter("idContact"));

		try{
		
			 ContactDAO p = new ContactDAO();
	           p.UpdateContact(nom,prenom,num_tel,type_tel,categorie,idContact);
	           response.sendRedirect("ListContact.jsp");
		}catch(Exception e)
		{
			System.out.println("e="+e.getMessage());
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}
