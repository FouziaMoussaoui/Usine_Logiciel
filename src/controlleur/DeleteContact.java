package controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;

public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int IdContact =Integer.parseInt(request.getParameter("IdContact"));
		try{
		
			 ContactDAO p = new ContactDAO();
	           p.DeleteContact(IdContact);
	           response.sendRedirect("ListContact.jsp");
		}catch(Exception e)
		{
			System.out.println("e="+e.getMessage());
			}

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
