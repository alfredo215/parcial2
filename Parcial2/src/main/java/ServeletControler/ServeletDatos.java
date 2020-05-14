package ServeletControler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alfredo.Dao.datosDAO;
import com.alfredo.model.Consulta;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServeletDatos
 */
public class ServeletDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Consulta cl =new Consulta();
		datosDAO cldao = new datosDAO();
		
		String id = null;
		String nombrepr = null;
		String apellidopr = null;

		
		try {
		 id= request.getParameter("Id");
		 nombrepr= request.getParameter("Unombre");
		 apellidopr= request.getParameter("Uapellido");

		 
			cl.setId(Integer.parseInt(id));
			cl.setNombre(nombrepr);
			cl.setApellido(apellidopr);
		}catch (Exception e) {
			
		}
		
		String acction=request.getParameter("btn");
		
		 if(acction.equals("Actualizar")) {
		cl.setId(Integer.parseInt(id));
		cl.setNombre(nombrepr);
		cl.setApellido(apellidopr);

		
		cldao.actualizarDatos(cl);
		}
		else if(acction.equals("Eliminar")) {
			cl.setId(Integer.parseInt(id));
			
			cldao.eliminarDatos(cl);
		};
		response.sendRedirect("index.jsp");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		datosDAO cldao = new datosDAO();
		Gson json = new Gson();
		
		try {
			response.getWriter().append(json.toJson(cldao.consultaLista()));
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		
		//doGet(request, response);
	}

}
