package conector;

import java.sql.*;

public class conectorPostgres {
	
	private String URL = "jdbc:postgresql://localhost:5432/alrel";
	private String user = "postgres";
	private String password = "basedatos";
	
	public conectorPostgres() throws SQLException {
		Connection conexion = DriverManager.getConnection(URL,user,password);
		String query = "SELECT * FROM cli_compensar";
		Statement queryStatement = conexion.createStatement();
		ResultSet result = queryStatement.executeQuery(query);
		result.next();
		System.out.println(result.getString(3));
	}

}
