package Neu0224;
import java.sql.*;
public class demo6 {
	public static void main(String[] args) {
		//初始化 url user password
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String user = "root";
		String password = "123456";
		//将con pstmt rs 的作用域扩大;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			con = DriverManager.getConnection(url, user, password);
			//创建命令窗口(输入sql语句) 如果是查询操作 则调用executeQuery方法 返回值为ResultSet
			//如果是增加 删除 修改操作则调用executeUpdate方法 返回值为 int 表示受影响的行数
//			pstmt = con.prepareStatement("select * from demo");
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
//			}
			//修改操作
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
