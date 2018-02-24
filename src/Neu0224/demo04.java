package Neu0224;

import java.sql.*;


public class demo04 {
	
	public static void main(String[] args) {
		//选择要操作的数据库种类---加载驱动(反射)
		//格式  jdbc:mysql://主机ip:端口号/数据库名
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		String user = "root";
		String password = "123456";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 主机IP 端口号 用户名 密码
			con = DriverManager.getConnection(url, user, password);
			
			//创建命令窗口(写sql语句)  如果是更新操作则调用executeUpdate 返回 int 为受影响的行数
			//如果查询的时候  则调用executeQuery()  返回ResultSet
			pstmt = con.prepareStatement("select * from demo");
			//查询结果返回
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

