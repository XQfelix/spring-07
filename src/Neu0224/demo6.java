package Neu0224;
import java.sql.*;
public class demo6 {
	public static void main(String[] args) {
		//��ʼ�� url user password
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String user = "root";
		String password = "123456";
		//��con pstmt rs ������������;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			con = DriverManager.getConnection(url, user, password);
			//���������(����sql���) ����ǲ�ѯ���� �����executeQuery���� ����ֵΪResultSet
			//��������� ɾ�� �޸Ĳ��������executeUpdate���� ����ֵΪ int ��ʾ��Ӱ�������
//			pstmt = con.prepareStatement("select * from demo");
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
//			}
			//�޸Ĳ���
			pstmt = con.prepareStatement("update demo set name=(?) where name=(?)");
			pstmt.setString(1, "hello");
			pstmt.setString(2, "mike");
			
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
					if(con!=null){
					con.close();
					}
					if(pstmt!=null){
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
