package ServeletControler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.alfredo.Dao.loguinDAO;
import com.alfredo.model.Usuarioparcial;

/**
 * Servlet implementation class ServeletUser
 */
public class ServeletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletUser() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String usu = request.getParameter("user");
		String contra = request.getParameter("pass");
		
		
		
		Usuarioparcial user = new Usuarioparcial();
		
		loguinDAO usuDao = new loguinDAO();
		
		user.setNombre(usu);
		user.setContrasenia(contra);
		
		int verificacion=usuDao.EntradaUsuario(user).size();
		if(verificacion==1) {
			JOptionPane.showMessageDialog(null, "Entraste");
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o contrasenia incorrectos");
		}
		response.sendRedirect("index.jsp");
		
		
		
	}

}
