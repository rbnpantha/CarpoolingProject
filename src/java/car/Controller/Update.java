package car.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.business.UserProcessing;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("txtFullName");
		String state=request.getParameter("txtState");
		String city=request.getParameter("txtCity");
		String street=request.getParameter("txtStreet");
		int zip=Integer.parseInt(request.getParameter("txtZipCode"));
		int birth=Integer.parseInt(request.getParameter("txtBirthYear"));
		UserProcessing user=new UserProcessing();
		String email=(String)session.getAttribute("reg");
		boolean regFlag=false;
		try {
			
			regFlag=user.updateUser(name, state, city, street, zip, birth,email);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(regFlag){
			
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}
		else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	}


