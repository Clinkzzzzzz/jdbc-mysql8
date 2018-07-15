package helloworld;
import java.sql.*;

public class helloworld {
	static final String Jdbc_driver="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	static final String DB_name="root";
	static final String DB_password="whosyourdaddy";
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		
		try {
			Class.forName(Jdbc_driver);
			System.out.println("Connecting to db...");
			conn=DriverManager.getConnection(DB_URL, DB_name, DB_password);
			System.out.println("Creating statmenmt...");
			stmt=conn.createStatement();
			String sql;
			sql="select id,name,login_name,password,email from sys_user";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("login_name"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("email"));
			}
			rs.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
			}catch(SQLException se) {}
			try {
				if(conn!=null)conn.close();
			}catch(SQLException se) {}
		}
		System.out.println("ojbk");
	}
}
