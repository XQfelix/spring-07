package Demo;

import java.sql.*;

/**
 * 测试根数据库建立连接
 * 
 * */
public class Demo01 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
		
	
//		Statement stmt = con.createStatement();
//		String sql = "insert into t_user(username,pwd,regTime) values ('王7',6666,now())";
//		stmt.execute(sql);
		
		
		
	}
}
