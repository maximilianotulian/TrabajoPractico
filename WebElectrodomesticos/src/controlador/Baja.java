package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Baja
 */
public class Baja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Baja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int ID = Integer.parseInt(request.getParameter("id"));
		
		Statement sta;
		try {
	        
			sta = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs = (ResultSet) sta.executeQuery("SELECT * FROM electrodomestico WHERE id="+ID+"");
			if(rs.next())
			{
				int dialogResult =JOptionPane.showConfirmDialog (null, "�Est� seguro que desea eliminar el electrodomestico?","Cuidado!", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
					sta.executeUpdate("DELETE FROM electrodomestico WHERE id="+ID+"");
			}
			else
				JOptionPane.showMessageDialog(null, "El Id ingresado es inexistente");
			sta.close();
			Conexion.CloseConnection();	
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		request.getRequestDispatcher("/Baja.jsp").forward(request, response);
	}

}
