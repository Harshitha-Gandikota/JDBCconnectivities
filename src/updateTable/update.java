package updateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/schema1";
	private static final String user="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Class.forName(driver);
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,password);
			String sql="update table1 set ?=? where id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter column name: ");
			pmst.setString(1, s.next());
			System.out.println("enter column value: ");
			pmst.setString(2, s.next());
			System.out.println("enter id number: ");
			pmst.setInt(3, s.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Data not inserted");
			}
			pmst.close();
			conn.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}