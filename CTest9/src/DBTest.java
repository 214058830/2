import java.sql.*;

public class DBTest {

	public static void main(String[] args)
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//加载对应的jdbc驱动
			String url="jdbc:sqlserver://localhost:1433; DatabaseName=student_course";
			//配置连接字符串
			String user="sa";//sa超级管理员
			String password="sa123";//密码
			Connection conn=DriverManager.getConnection(url,user,password);
			//创建数据库连接对象
			Statement st=conn.createStatement();
			//创建SQL语句执行对象
			//String strSQL="delete from student where sname='王三'";
			//String strSQL="update student set sage=30 where sname='王四'";
			String strSQL="insert into student values('201715166','王三','男',20,'IS',1)";
			//组织SQL语句
			st.execute(strSQL);
			//执行SQL语句
			conn.close();
			//关闭数据库连接
		}
		catch (ClassNotFoundException ex) {
			System.out.println("没有找到对应的数据库驱动类");
		}
		catch (SQLException ex) {
			System.out.println("数据库连接或者是数据库操作失败");
		}

	}

}
