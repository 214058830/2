package all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    public static Connection getConnection() {

        Connection con = null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="root";
        String password="13572281710";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        return con;

    }
    public static void release(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }
}