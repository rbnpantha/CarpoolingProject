package car.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.business.DeleteProcess;
import car.business.PostProcessing;
import com.google.gson.Gson;

/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePost() {
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
		String mes="";
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		String value=(String)session.getAttribute("reg");
		DeleteProcess pos=new DeleteProcess();
				try {
			pos.getId(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
	}

}
