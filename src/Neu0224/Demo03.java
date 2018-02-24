package Neu0224;

import java.sql.*;

/**
 * ����PrepardStatement�Ļ����÷�
 * 
 * */

public class Demo03 {
	public static void main(String[] args) {
		String user="root";
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String password = "123456";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
		    con = DriverManager.getConnection(url,user,password);
		    pstmt = con.prepareStatement("insert into demo(name) values(?)");
		    pstmt.setString(1, "mike");
		    int i = pstmt.executeUpdate();
		    System.out.println(i);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
}
