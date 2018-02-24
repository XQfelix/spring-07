package Neu0224;

import java.sql.*;


public class demo04 {
	
	public static void main(String[] args) {
		//ѡ��Ҫ���������ݿ�����---��������(����)
		//��ʽ  jdbc:mysql://����ip:�˿ں�/���ݿ���
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String user = "root";
		String password = "123456";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����IP �˿ں� �û��� ����
			con = DriverManager.getConnection(url, user, password);
			
			//���������(дsql���)  ����Ǹ��²��������executeUpdate ���� int Ϊ��Ӱ�������
			//�����ѯ��ʱ��  �����executeQuery()  ����ResultSet
			pstmt = con.prepareStatement("select * from demo");
			//��ѯ�������
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
				try {
					if(rs!=null){
					rs.close();
					}
					if(pstmt!=null){
				 		pstmt.close();
					}
					if(con!=null){
						pstmt.close();			
				    }
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
	}

