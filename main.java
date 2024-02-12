package dbNew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class main {

	private static Connection connect = null;
	private static Statement statement = null;
	private static Scanner scan = new Scanner(System.in);

	final private static String host = "jdbc:postgresql://10.98.98.61:5432/group52";
	final private static String user = "group52";
	final private static String password = "cW$L67Ez2U?9@Uq4";

	private static void maestro(String command) {

		switch (command) {

		case "1":
			createProduct();
			break;
		case "2":
			createCampaign();
			break;
		case "3":
			createEmployee();
			break;
		case "4":
			deleteProduct();
			break;
		case "5":
			updateProduct();
			break;
		case "6":
			listProducts();
			break;
		case "7":
			listCampaign();
			break;
		case "8":
			listEmployee();
			break;
		case "9":
		}

	}

	private static void createProduct() {

		String typeId = "1";
		String brandId = "1";

		String productName = "";
		String amount = "";
		String expirationDate = "";

		System.out.println("Please type Product Name");
		productName = scan.nextLine();

		System.out.println("Please type Amount");
		amount = scan.nextLine();

		System.out.println("Please type Expiration Date");
		expirationDate = scan.next();

		try {
			statement.executeUpdate("INSERT INTO PRODUCTS (AMOUNT,NAME,BRANDID,TYPEID,EXPIRATIONDATE) VALUES ('"
					+ amount + "','" + productName + "','" + brandId + "','" + typeId + "','" + expirationDate + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void createCampaign() {

		String productID = "1";

		String campaignName;
		String rate;
		String duration;

		System.out.println("Please type Campaign Name");
		campaignName = scan.nextLine();

		System.out.println("Please type Rate");
		rate = scan.nextLine();

		System.out.println("Please type Duration");
		duration = scan.next();

		try {
			statement.executeUpdate("INSERT INTO CAMPAIGN (PRODUCTID,RATE,NAME,DURATION) VALUES ('"
					+ productID + "','" + rate + "','" + campaignName + "','" + duration+"')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void createEmployee() {
		
		

		String personID = "1";
		String title = "";
		

	
		System.out.println("Please type Title");
		title = scan.nextLine();

		
		try {
			statement.executeUpdate("INSERT INTO EMPLOYEE (PERSONID,TITLE) VALUES ('"
					+ personID + "','" + title + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void listProducts() {

		try {
			ResultSet rs = statement.executeQuery("select * from products");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(" ");
				System.out.print(rs.getString(2));
				System.out.print(" ");
				System.out.print(rs.getString(3));
				System.out.print(" ");
				System.out.print(rs.getString(4));
				System.out.print(" ");
				System.out.print(rs.getString(5));
				System.out.print(" ");
				System.out.println(rs.getString(6));
				System.out.println(" ");
				System.out.println(" ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static void listCampaign() {
		try {
		ResultSet rs = statement.executeQuery("select * from campaign");
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print(" ");
			System.out.print(rs.getString(2));
			System.out.print(" ");
			System.out.print(rs.getString(3));
			System.out.print(" ");
			System.out.print(rs.getString(4));
			System.out.print(" ");
			System.out.print(rs.getString(5));
			System.out.println(" ");
			System.out.println(" ");
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
		
	}

	private static void listEmployee() {
		
		try {
		ResultSet rs = statement.executeQuery("select * from employee");
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print(" ");
			System.out.print(rs.getString(2));
			System.out.print(" ");
			System.out.print(rs.getString(3));
			System.out.println(" ");
			System.out.println(" ");
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	
	
	private static void deleteProduct() {

		listProducts();

		System.out.println("Please type productID you want to delete");
		String productID = scan.nextLine();

		try {
			statement.executeUpdate("DELETE FROM PRODUCTS WHERE ID =" + productID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void updateProduct() {
		String productName = "";
		String amount = "";
		String expirationDate = "";
		listProducts();

		System.out.println("Please type productID you want to update");
		String productID = scan.nextLine();

		System.out.println("Please type Product Name");
		productName = scan.nextLine();

		System.out.println("Please type Amount");
		amount = scan.nextLine();

		System.out.println("Please type Expiration Date");
		expirationDate = scan.next();

		try {
			statement.executeUpdate("UPDATE PRODUCTS SET NAME ='" + productName + "', AMOUNT = '" + amount
					+ "', expirationDate='" + expirationDate + "' WHERE ID = " + productID);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String command = "0";

		try {
			connect = DriverManager.getConnection(host, user, password);
			System.out.println("Connection successful");

			statement = connect.createStatement();
			while (!command.equals("9")) {

				System.out.println("Please select a suitable comment");
				System.out.println("1: Create Product");
				System.out.println("2: Create Campaign");
				System.out.println("3: Create Employee");
				System.out.println("4: Delete Product");
				System.out.println("5: Update Product");
				System.out.println("6: List Products");
				System.out.println("7: List Campaigns");
				System.out.println("8: List Employee");
				System.out.println("9: Exit");
				System.out.println(" ");

				command = scan.nextLine();

				maestro(command);

			}

		} catch (SQLException e) {

			System.out.println("Failure");
			e.printStackTrace();

		}

		finally {

		}

	}

}
