package develop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySqlTest {
	public static void main(String[] args)  {
		 // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/solr?useUnicode=true&characterEncoding=UTF8";

        // MySQL配置时的用户名
        String user = "root"; 

        // MySQL配置时的密码
        String password = "";

  
         // 加载驱动程序
         try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         // 连续数据库
         Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         String sql="insert into t_users(id,name,age) values(?,?,?)";
         PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         for(int i=100050;i<100150;i++){
        	 try {
        		 pst.setInt(1, i+1);
				 pst.setString(2, "海凤"+i);
				 pst.setInt(3, i);
				 pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
         }
        
        // pst.close();
        // conn.close();
	}
	
}
