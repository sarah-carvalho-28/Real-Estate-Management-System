import java.sql.*;
class DBConn
{
	Connection con;
	DBConn()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate","root","");
	}
}