package dropDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class dbDrop {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String user="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
public static void main(String[] args) {
	
	try {
		Scanner s=new Scanner(System.in);
		Class.forName(driver);
		conn= DriverManager.getConnection(url,user,password);
		System.out.println("Enter Database name: ");
		String sql="drop database "+s.nextLine();
		pmst=conn.prepareStatement(sql);
		int i = pmst.executeUpdate();
		if(i==0) {
			System.out.println("database is dropped");
		}
		else {
			System.out.println("database is not dropped");
		}
		pmst.close();
		conn.close();
		s.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
