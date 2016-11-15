package car.Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.business.UserProcessing;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
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
		String gender=request.getParameter("rdGender");
		String state=request.getParameter("txtState");
		String city=request.getParameter("txtCity");
		String street=request.getParameter("txtStreet");
		int zip=Integer.parseInt(request.getParameter("txtZipCode"));
		int birth=Integer.parseInt(request.getParameter("txtBirthYear"));
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		UserProcessing user=new UserProcessing();
		//System.out.println(name);
		boolean regFlag=false;
		try {
			regFlag=user.insertUser(name, gender, state, city,street, zip, birth, email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(regFlag){
			session.setAttribute("reg", email);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}
		else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
