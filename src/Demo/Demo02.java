package Demo;

import java.sql.*;

/**
 * 测试PrepardStatement的基本用法
 * 
 * */
public class Demo02 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
		
		String sql = "insert into t_user(username,pwd,regTime) values (?,?,?)";  //占位符
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "mike");
		ps.setString(2, "123");
		ps.setString(3, "2018-02-12 15:09:52");
		
		int i = ps.executeUpdate();
		System.out.println(i);
	}
}

