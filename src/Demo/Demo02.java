package Demo;

import java.sql.*;

/**
 * ����PrepardStatement�Ļ����÷�
 * 
 * */
public class Demo02 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//����������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
		
		String sql = "insert into t_user(username,pwd,regTime) values (?,?,?)";  //ռλ��
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "mike");
		ps.setString(2, "123");
		ps.setString(3, "2018-02-12 15:09:52");
		
		int i = ps.executeUpdate();
		System.out.println(i);
	}
}

