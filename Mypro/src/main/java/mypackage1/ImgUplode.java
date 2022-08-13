package mypackage1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *  implementation class ImgUplode
 */
@WebServlet("/ImgUplode")
@MultipartConfig
public class ImgUplode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int roll=Integer.parseInt(request.getParameter("roll"));
		Part img=request.getPart("img");
		if(img!=null) {
			System.out.println(img.getContentType());
			System.out.println(img.getName());
			System.out.println(img.getSize());
		}
		InputStream is=img.getInputStream();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/imgx","root","123456789");
			PreparedStatement ps=cn.prepareStatement("insert into photo (name,roll,photo)value(?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, roll);
			ps.setBlob(3, is);
			int i=ps.executeUpdate();
			if(i>0) {
				response.sendRedirect("imgx.html");
			}
			
			
		}catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
	}

}
