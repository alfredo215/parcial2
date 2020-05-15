package ServeletControler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.alfredo.Dao.datosDAO;
import com.alfredo.Dao.loguinDAO;
import com.alfredo.model.Consulta;
import com.alfredo.model.Usuarioparcial;
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
		System.out.println(acction);
		
		HttpSession seccion = (HttpSession) request.getSession();
		String Usuariovariable = (String)seccion.getAttribute("user");
		
		 if(acction.equals("Actualizar")) {
			 if(Usuariovariable==null){
				 JOptionPane.showMessageDialog(null, "No tienes permitido realizar esa accion porfabor inicia Session");
				 response.sendRedirect("Login.jsp");
				}else {
		cl.setId(Integer.parseInt(id));
		cl.setNombre(nombrepr);
		cl.setApellido(apellidopr);
		response.sendRedirect("index.jsp");
		
		cldao.actualizarDatos(cl);
				}
		}
		else if(acction.equals("Eliminar")) {
			if(Usuariovariable==null){
				JOptionPane.showMessageDialog(null, "No tienes permitido realizar esa accion porfabor inicia Session");
				response.sendRedirect("Login.jsp");
			}else {
			cl.setId(Integer.parseInt(id));
			cldao.eliminarDatos(cl);
			response.sendRedirect("index.jsp");
			}
		};
		
		
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
		//-------------------------------------------------------
		// Loguin
		String usu = request.getParameter("user");
		String contra = request.getParameter("pass");
		
		
		
		Usuarioparcial user = new Usuarioparcial();
		
		loguinDAO usuDao = new loguinDAO();
		
		user.setNombre(usu);
		user.setContrasenia(contra);
		
		int verificacion=usuDao.EntradaUsuario(user).size();
		if(verificacion==1) {
			
			
			HttpSession seccion = request.getSession(true);
			seccion.setAttribute("user",usu);
			
			response.sendRedirect("index.jsp");
		}else if(verificacion==0){
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario o contrasenia incorrectos");
		}
		
		//-------------------------------
		//doGet(request, response);
	}

}
