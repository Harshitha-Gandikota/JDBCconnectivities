package dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicApplication {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String user="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner s=new Scanner(System.in);
			System.out.println("Choose your choice");
			DisplayMenu();
			choice= Integer.parseInt(s.next());
			switch(choice) {
			case 1: createDatabase();
			break;
			case 2:dropDatabase();
			break;
			case 3:insertData();
			break;
			case 4:deleteById();
			break;
			case 5:updateData();
			break;
			case 6:getById();
			break;
			case 7:getAll();
			break;
			case 8:login();
			break;
			case 9:System.exit(0);
			break;
			default: System.out.println("invaild");
			}
		}while(choice>0);
	}

	private static void login() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="select * from "+s.next()+" where email=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter email: ");
			pmst.setString(1, s.next());
			ResultSet rs= pmst.executeQuery();
			if (rs.next()) {
				System.out.println("Login Successful");
			}
			else {
				System.out.println("Login not Successful");
			}
			pmst.close();
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void getById() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="select * from "+s.next()+" where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter order id: ");
			pmst.setInt(1, s.nextInt());
			ResultSet rs= pmst.executeQuery();
			while (rs.next()) {
				System.out.println("Order_id: "+rs.getInt("order_id"));
				System.out.println("order_name: "+rs.getString("order_name"));
				System.out.println("pincode: "+rs.getString("pincode"));
			}
			pmst.close();
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void dropDatabase() {
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			String url="jdbc:mysql://localhost:3306/";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getAll() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="select * from "+s.next();
			pmst=conn.prepareStatement(sql);
			ResultSet rs= pmst.executeQuery();
			while (rs.next()) {
				System.out.println("Order_id: "+rs.getInt("order_id"));
				System.out.println("order_name: "+rs.getString("order_name"));
				System.out.println("pincode: "+rs.getString("pincode"));
			}
			pmst.close();
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void updateData() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);		
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="update "+s.next()+" set order_name=? , pincode=? where order_id=?";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter order name: ");
			pmst.setString(1, s.next());
			System.out.println("enter pincode: ");
			pmst.setString(2, s.next());
			System.out.println("enter order id: ");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteById() {
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);		
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="delete from "+s.next()+" where order_id=?";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter order id: ");
			pmst.setInt(1, s.nextInt());
						
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data deleted");
			}
			else {
				System.out.println("Data not deleted");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertData() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);		
			System.out.println("enter database name: ");
			String url="jdbc:mysql://localhost:3306/"+s.next();
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter table name: ");
			String sql="insert into "+s.next()+"(order_id,order_name,pincode) values(?,?,?)";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter order id: ");
			pmst.setInt(1, s.nextInt());
			System.out.println("enter order name: ");
			pmst.setString(2, s.next());
			System.out.println("enter pincode: ");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createDatabase() {
		try {
			Scanner s=new Scanner(System.in);
			Class.forName(driver);		
			String url="jdbc:mysql://localhost:3306/";
			conn= DriverManager.getConnection(url,user,password);
			System.out.println("Enter Database name: ");
			String sql="create database "+s.nextLine();
			pmst=conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("database is created");
			}
			else {
				System.out.println("database is not created");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void DisplayMenu() {
		System.out.println("\t1.Create database");
		System.out.println("\t2.Drop database");
		System.out.println("\t3.Data Insertion");
		System.out.println("\t4.Delete by id");
		System.out.println("\t5.Update data");
		System.out.println("\t6.Get by id");
		System.out.println("\t7.Get all");
		System.out.println("\t8.Login");
		System.out.println("\t9.Exit");

	}

}
