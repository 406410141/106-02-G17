package tetris;
import java.sql.*;

public class Leader {
	
	private Connection con;
	
    public void connect() throws Exception{

        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("No database");
        }

        String connectionURL = "jdbc:mysql://localhost:3306/Peoples";

        con = DriverManager.getConnection(connectionURL, "root", "0000");        
    }
	public void leader() {
		// TODO Auto-generated method stub
		
	}

}
