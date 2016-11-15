package car.Controller;

import car.business.PostProcessing;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
	//response.getWriter().println("login");
		/*ArrayList<String> al=new ArrayList<>();
		PostProcessing pp=new PostProcessing();
		try {
			al=pp.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("data", al);
		request.getRequestDispatcher("home.jsp").forward(request, response);*/
	String mes="";
	response.setContentType("application/json");
	PrintWriter out=response.getWriter();
	PostProcessing pos=new PostProcessing();
	
	try{
		Gson gson=new Gson();
		String message=gson.toJson(pos.GetMessage());
		out.println("{\"Message\":"+message+"}");
		System.out.println(message);
		/*File file=new File("z:\\test.json");
		file.createNewFile();
		FileWriter writer=new FileWriter("z:\\test.json");
		writer.write("{\"Message\":"+message+"}");
		mes="{\"Message\":"+message+"}";
		writer.flush();
		writer.close();*/

	}
	catch(Exception ex){
		System.out.println(ex.toString());
	}
	//response.sendRedirect("home.jsp");
	/*request.setAttribute("msg", mes);
	request.getRequestDispatcher("home.jsp").forward(request, response);*/
	}
}
