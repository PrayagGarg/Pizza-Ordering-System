package pack9;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Vector;
public class AD {
Connection conn=null;
java.sql.PreparedStatement pst;
public static Connection dbconnect() throws SQLException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/banking","root","");
		return conn;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
}
