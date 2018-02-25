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
			//选择要操作的数据种类---加载驱动(反射)
			//格式: jdbc:mysql://主机 ip:端口号/数据库名
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			con = DriverManager.getConnection(url,user,password);
			//创建命令窗口(写sql语句) 如果是更新操作调用executeUpdate  返回值 int 为受影响的行数,
			//如果是查询操作,调用executeQuery  返回值为ResultSet
//			pstmt = con.prepareStatement("select * from demo");
//			//返回查询结果
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
//			}
			
			//插入操作
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
