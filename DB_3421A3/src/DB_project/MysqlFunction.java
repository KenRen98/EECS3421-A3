package DB_project;
import java.sql.*;

public class MysqlFunction {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mrleavesbbs.com:3306/cfp";
    static final String USER = "3421a3";
    static final String PASS = "kenren98";
    
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static Connection getConnection() throws Exception {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded£¡");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    
    public static void close() throws SQLException{
		if(rs!=null) {
			rs.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
}
