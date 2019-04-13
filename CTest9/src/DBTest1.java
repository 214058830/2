import java.sql.*;


public class DBTest1 {

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
			String strSQL="select ssex,sno,sname,sage,sdept from student";
			ResultSet rs=st.executeQuery(strSQL);
			//执行SQL语句
			while(rs.next())//判断结果集中是否还有下一条查询记录
			{
				System.out.print("学号:"+rs.getString(2));
				System.out.print("姓名:"+rs.getString(3));
				System.out.print("性别:"+rs.getString(1));
				System.out.print("年龄:"+rs.getInt(4));
				System.out.print("院系:"+rs.getString(5));
				System.out.println();
			}
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
