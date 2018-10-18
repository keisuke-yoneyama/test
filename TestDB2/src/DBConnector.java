
/**
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>
 * mysqlに接続するためのユーティリティクラスです。<br>
 * ルートアカウントにてDBに接続されます。
 * </p>
 */
public class DBConnector {
	/**
	 * JDBCdriver name
	 *
	 */
	private static String driverName = "com.mysql.jdbc.Driver";
	/**
	 * database setsuzoku URL
	 */
	private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";

	/**
	 * database setsuzoku username
	 */

	private static String user = "root";

	/**
	 * database password
	 */
	private static String password = "mysql";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
