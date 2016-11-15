package car.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.business.CommentInsert;

/**
 * Servlet implementation class InsertComment
 */
@WebServlet("/InsertComment")
public class InsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String comment=request.getParameter("txtcomment");
		int postid=Integer.parseInt(request.getParameter("txthidden"));
		String sess=(String)session.getAttribute("reg");
		boolean flag=false;
		CommentInsert con=new CommentInsert();
		try{
			flag=con.insertComment(sess, postid, comment);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		if(flag==true){
			response.sendRedirect("home.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}

}
