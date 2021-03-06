package tetris;

import java.sql.*;


public class Leader {
	public static void main(String[] args) throws Exception
	{
		// 1.載入驅動，使用反射的知識，現在記住這麼寫。
		Class.forName("com.mysql.jdbc.Driver");
		try(
			// 2.使用DriverManager獲取資料庫連接,
			// 其中返回的Connection就代表了Java程式和資料庫的連接
			// 不同資料庫的URL寫法需要查驅動文件知道，使用者名稱、密碼由DBA分配
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/selection?verifyServerCertificate=false&useSSL=false&requireSSL=false&serverTimezone=UTC"
				, "root" , "0000");
			// 3.使用Connection來建立一個Statment物件
			Statement stmt = conn.createStatement();
			)
		{
			// 4.執行SQL語句
			/*
			Statement有三種執行sql語句的方法：
			1 execute 可執行任何SQL語句。- 返回一個boolean值，
			  如果執行後第一個結果是ResultSet，則返回true，否則返回false
			2 executeQuery 執行Select語句 － 返回查詢到的結果集
			3 executeUpdate 用於執行DML語句。－ 返回一個整數，
			  代表被SQL語句影響的記錄條數
			*/
			stmt.execute("INSERT INTO terist (name, score) VALUES ('A', 30)");
			ResultSet rs = stmt.executeQuery(
					"SELECT * from terist ORDER BY score DESC");		
			// ResultSet有系列的getXxx(欄索引 | 欄名)，用於獲取記錄指位器
			// 指向列、特定欄的值，不斷地使用next()將記錄指位器下移一行，
			// 如果移動之後記錄指位器依然指向有效列，則next()方法返回true。
			int rank = 1;
			while(rs.next())
			{
				System.out.println(rank + "\t" + rs.getInt(1) + "\t"
					+ rs.getString(2) + "\t"
					
					+ rs.getInt(3));
				rank++;
			}
		}
	}
}
