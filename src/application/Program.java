package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();

		for (int i = 1; i <= numberProducts; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported? (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextInt();
			if (type == 'c') {
				Product product = new Product(name, price);
				list.add(product);
			} else if (type == 'u') {
				System.out.print("Data de fabricacao (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product product = new UsedProduct(name, price, date);
				list.add(product);
			} else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);

			}

		}
		System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());

		}
		sc.close();
	}
}
