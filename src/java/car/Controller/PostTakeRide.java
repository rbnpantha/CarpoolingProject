package car.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.business.PostProcessing;
import com.google.gson.Gson;

/**
 * Servlet implementation class PostTakeRide
 */
@WebServlet("/PostTakeRide")
public class PostTakeRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTakeRide() {
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
		String mes="";
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		car.business.PostTakeRide pos=new car.business.PostTakeRide();
		
		try{
			Gson gson=new Gson();
			String message=gson.toJson(pos.GetMessage());
			out.println("{\"Message\":"+message+"}");
			System.out.println(message);
	}
		catch(Exception ex){
			ex.getMessage();
			}
		}

}
