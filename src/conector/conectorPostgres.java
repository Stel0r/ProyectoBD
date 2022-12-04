package conector;

import java.sql.*;

public class conectorPostgres {
	
	private String URL;
	
	public conectorPostgres() throws SQLException {
		Connection conexion = DriverManager.getConnection(URL);
	}

}
