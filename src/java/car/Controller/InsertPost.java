package car.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.business.PostInsert;

/**
 * Servlet implementation class InsertPost
 */
@WebServlet("/InsertPost")
public class InsertPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPost() {
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
		String text=request.getParameter("txtPost");
		String type=request.getParameter("rdType");
		String sess=(String)session.getAttribute("reg");
		boolean flag=false;
		PostInsert poi=new PostInsert();
		try{
			flag=poi.insertPost(sess, text, type);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(flag==true){
			response.sendRedirect("home.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}

}
