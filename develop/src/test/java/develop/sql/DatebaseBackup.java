package develop.sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.hwl.util.database.DBUtils;

public class DatebaseBackup {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn= DBUtils.getConnection();
		
	}
}
