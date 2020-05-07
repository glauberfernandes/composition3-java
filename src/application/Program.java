package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date clientDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientDate);
		
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
			
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int orderQuantity = sc.nextInt();		
		for(int i = 1; i <= orderQuantity; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String itemName = sc.nextLine();
			System.out.print("Product price: ");
			Double itemPrice = sc.nextDouble();
			
			Product product = new Product(itemName, itemPrice);
			
			System.out.print("Quantity: ");
			Integer itemQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(itemQuantity, itemPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
	
		sc.close();
	}

}
