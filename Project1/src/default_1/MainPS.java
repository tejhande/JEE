package default_1;

import java.sql.SQLException;

public class MainPS {

	public static void main(String[] args) throws SQLException {
		PreparedStmt ps = new PreparedStmt();
		ps.insertData();
		ps.updateData();
		ps.deleteData();
		ps.fetchData();
	}

}
