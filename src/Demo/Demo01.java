package Demo;

import java.sql.*;

/**
 * ���Ը����ݿ⽨������
 * 
 * */
public class Demo01 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//����������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
		
	
//		Statement stmt = con.createStatement();
//		String sql = "insert into t_user(username,pwd,regTime) values ('��7',6666,now())";
//		stmt.execute(sql);
		
		
		
	}
}
