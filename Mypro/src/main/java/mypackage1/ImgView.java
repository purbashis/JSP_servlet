package mypackage1;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ImageView
 */
@WebServlet("/ImageView")
public class ImgView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		//int roll= Integer.parseInt(request.getParameter("roll"));
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		//System.out.println(roll);
		Connection cn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/imgx","root","123456789");
			ps=cn.prepareStatement("select * from photo where roll='"+id+"'");
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				byte[] img=rs.getBytes("photo");
				OutputStream os=response.getOutputStream();
				os.write(img);
				os.close();
				os.flush();
			}
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}