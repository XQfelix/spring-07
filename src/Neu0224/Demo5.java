package Neu0224;
import java.sql.*;

public class Demo5 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String user = "root";
		String password = "123456";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//ѡ��Ҫ��������������---��������(����)
			//��ʽ: jdbc:mysql://���� ip:�˿ں�/���ݿ���
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			con = DriverManager.getConnection(url,user,password);
			//���������(дsql���) ����Ǹ��²�������executeUpdate  ����ֵ int Ϊ��Ӱ�������,
			//����ǲ�ѯ����,����executeQuery  ����ֵΪResultSet
//			pstmt = con.prepareStatement("select * from demo");
//			//���ز�ѯ���
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
//			}
			
			//�������
			pstmt = con.prepareStatement("insert into demo(id,name) values(?,?)");
			pstmt.setInt(1, 5);
			pstmt.setString(2, "tom");
			int i = pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			{
				try {
					if(rs!=null){
					rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					if(con!=null){
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
