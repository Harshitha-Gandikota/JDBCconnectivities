package insertTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/db1";
	private static final String user="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,password);
			String sql="insert into order(order_id,order_name,pincode) values(?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter id: ");
			pmst.setInt(1, s.nextInt());
			System.out.println("enter name: ");
			pmst.setString(2, s.next());
			System.out.println("enter passsword: ");
			pmst.setString(3, s.next());
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
