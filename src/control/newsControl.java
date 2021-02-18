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
 * Servlet implementation class newsControl
 */
@WebServlet("/newsControl")
public class newsControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newsControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DButil db = new DButil();
		List<newsModule> list = new ArrayList<newsModule>();
		String operator = request.getParameter("operator");
		int count = 0;
		try {
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) as count from newsdetail");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("count", count);
		if (operator.equals("add")) {
			String newsTitle = request.getParameter("newsTitle");
			String newsType = request.getParameter("newsType");
			String newsAuthor = request.getParameter("newsAuthor");
			String newsContent = request.getParameter("newsContent");
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into newsdetail(newsTitle,newsType,newsAuthor,newsContent) values (?,?,?,?)");
				pstmt.setString(1, newsTitle);
				pstmt.setString(2, newsType);
				pstmt.setString(3, newsAuthor);
				pstmt.setString(4, newsContent);
				pstmt.executeUpdate();
				request.setAttribute("flag", 0);
				request.getRequestDispatcher("manageControl").forward(request, response);
				db.closeConnectioon(conn, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("delete")) {
			String newsId = request.getParameter("id");
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from newsdetail where newsId=?");
				pstmt.setString(1, newsId);
				pstmt.executeUpdate();
				request.setAttribute("flag", 2);
				request.getRequestDispatcher("manageControl").forward(request, response);
				db.closeConnectioon(conn, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("edit")) {
			String newsId = request.getParameter("id");
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail where newsId = ?");
				pstmt.setString(1, newsId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString(1);
					if (newsId.equals(id)) {
						newsModule nm = new newsModule();
						nm.setId((rs.getInt("newsId")));
						nm.setTitle(rs.getString("newsTitle"));
						nm.setType(rs.getString("newsType"));
						nm.setAuthor(rs.getString("newsAuthor"));
						nm.setContent(rs.getString("newsContent"));
						nm.setTime(rs.getString("newsTime"));				
						list.add(nm);	
					}
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("editView.jsp").forward(request, response);
				db.closeConnectioon(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("editNews")) {
			String newsId = request.getParameter("id");
			String newsTitle = request.getParameter("newsTitle");
			String newsType = request.getParameter("newsType");
			String newsAuthor = request.getParameter("newsAuthor");
			String newsContent = request.getParameter("newsContent");
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update newsdetail set newsTitle=?,newsType=?,newsAuthor=?,newsContent=? where newsId=?");
				pstmt.setString(1, newsTitle);
				pstmt.setString(2, newsType);
				pstmt.setString(3, newsAuthor);
				pstmt.setString(4, newsContent);
				pstmt.setString(5, newsId);
				pstmt.executeUpdate();
				request.setAttribute("flag", 1);
				request.getRequestDispatcher("manageControl").forward(request, response);
				db.closeConnectioon(conn, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("search")) {
			String newsTitle = request.getParameter("newsTitle").trim();
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail  where newsTitle like ?");
				pstmt.setString(1, '%' + newsTitle + '%');
				ResultSet rs = pstmt.executeQuery();
				if (newsTitle == null || "".equals(newsTitle)) {
					request.setAttribute("flag", 1);
					request.getRequestDispatcher("searchView.jsp").forward(request, response);
				} else {
					request.setAttribute("flag", 1);			
				}
				while (rs.next()) {
					newsModule nm = new newsModule();
					nm.setId(rs.getInt("newsId"));
					nm.setTitle(rs.getString("newsTitle"));
					nm.setType(rs.getString("newsType"));
					nm.setAuthor(rs.getString("newsAuthor"));
					nm.setTime(rs.getString("newsTime"));
					list.add(nm);
					request.setAttribute("list", list);
					request.setAttribute("flag", 0);
				}
				request.getRequestDispatcher("searchView.jsp").forward(request, response);
				db.closeConnectioon(conn, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (operator.equals("show")) {
			String newsId = request.getParameter("id");
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail where newsId = ?");
				pstmt.setString(1, newsId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString(1);
					if (newsId.equals(id)) {
						newsModule nm = new newsModule();
						nm.setId(rs.getInt("newsId"));
						nm.setTitle(rs.getString("newsTitle"));
						nm.setType(rs.getString("newsType"));
						nm.setAuthor(rs.getString("newsAuthor"));
						nm.setContent(rs.getString("newsContent"));
						nm.setTime(rs.getString("newsTime"));
						list.add(nm);	
					}
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("showView.jsp").forward(request, response);
				db.closeConnectioon(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("login")) {
			String adminName = request.getParameter("adminName").trim();
			String adminPwd = request.getParameter("adminPwd").trim();
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select adminPwd from newsadmin where adminName = ?");
				pstmt.setString(1, adminName);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String pwd = rs.getString(1);
					if (adminPwd.equals(pwd)) {
						request.getRequestDispatcher("manageControl").forward(request, response);
					} else {
						request.setAttribute("flag", 1);
						request.getRequestDispatcher("loginView.jsp").forward(request, response);
					}
				}
				db.closeConnectioon(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (operator.equals("pageAdd")){
			String currentPageStr = request.getParameter("id");
			int currentPage = Integer.parseInt(currentPageStr) + 1 ;
			if (currentPage >= count) {
				currentPage = count;
			}
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail where newsId = ?");
				pstmt.setInt(1, currentPage);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					if (currentPage == id) {
						newsModule nm = new newsModule();
						nm.setId(rs.getInt("newsId"));
						nm.setTitle(rs.getString("newsTitle"));
						nm.setType(rs.getString("newsType"));
						nm.setAuthor(rs.getString("newsAuthor"));
						nm.setContent(rs.getString("newsContent"));
						nm.setTime(rs.getString("newsTime"));
						list.add(nm);
					}
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("showView.jsp").forward(request, response);
				db.closeConnectioon(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (operator.equals("pageDel")) {
			String currentPageStr = request.getParameter("id");
			int currentPage = Integer.parseInt(currentPageStr) - 1;
			if (currentPage <= 1) {
				currentPage = 1;
			}
			try {
				Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from newsdetail where newsId = ?");
				pstmt.setInt(1, currentPage);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					if (currentPage == id) {
						newsModule nm = new newsModule();
						nm.setId(rs.getInt("newsId"));
						nm.setTitle(rs.getString("newsTitle"));
						nm.setType(rs.getString("newsType"));
						nm.setAuthor(rs.getString("newsAuthor"));
						nm.setContent(rs.getString("newsContent"));
						nm.setTime(rs.getString("newsTime"));
						list.add(nm);
					}
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("showView.jsp").forward(request, response);
				db.closeConnectioon(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
