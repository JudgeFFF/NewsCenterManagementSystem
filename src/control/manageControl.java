package control;

import java.sql.*;
import module.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class manageControl
 */
@WebServlet("/manageControl")
public class manageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DButil db = new DButil();
		List<newsModule> list = new ArrayList<newsModule>();
		try {
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				newsModule nm = new newsModule();
				nm.setId(rs.getInt("newsId"));
				nm.setTitle(rs.getString("newsTitle"));
				nm.setType(rs.getString("newsType"));
				nm.setAuthor(rs.getString("newsAuthor"));
				nm.setTime(rs.getString("newsTime"));
				list.add(nm);
				request.setAttribute("list", list);
			}
			request.getRequestDispatcher("manageView.jsp").forward(request, response);
			db.closeConnectioon(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
