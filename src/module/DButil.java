package module;

import java.sql.*;

public class DButil {
	private static final String url = "jdbc:mysql://localhost:3306/news?characterEncoding=utf-8";
	private static final String user = "root";
	private static final String pwd = "123456";
	Connection conn = null;

	public Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
        	// TODO: handle exception
			e.printStackTrace();
        }
        return conn;
    }
	
	public void closeConnectioon(Connection conn,PreparedStatement pstmt) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt !=null ) {
				pstmt.close();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeConnectioon(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt !=null ) {
				pstmt.close();
			}	
			if(rs !=null ) {
				rs.close();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
