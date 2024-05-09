package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.FileNameMap;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static final String FILE_NAME = "products.csv";
    public static ArrayList<Product> inventory = new ArrayList<Product>();
    public static ArrayList<Product> cart = new ArrayList<Product>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize variables
        double totalAmount = 0.0;

        // Load inventory from CSV file
        loadInventory("products.csv", inventory);
        boolean running = true;

        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Display menu and get user choice until they choose to exit
        while (running) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Call the appropriate method based on user choice
            switch (choice) {
                case 1:
                    displayProducts(inventory, cart, scanner);
                    break;
                case 2:
                    displayCart(cart, scanner, totalAmount);
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        scanner.close();
    }

    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] parts = line.split("\\|");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2]);
                    Product product = new Product(id, name, price);
                    inventory.add(product);

                }
            }
            bufferedReader.close();
        } catch(IOException e) {
            System.out.println("Invalid from the file " + e.getMessage());

        }

    }

    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        for (Product product : inventory) {
            System.out.println(product.getId() + ":" + product.getName() + "=$" + product.getPrice());
        }
        System.out.println("Please enter the ID of the product to add to your cart. ");
        String id = scanner.nextLine();
        System.out.println("Please enter the name of the product you want in your cart. ");
        String productName = scanner.nextLine().trim(); // Rename the variable
        Product foundProduct = findProductById(id);
        if (foundProduct != null) {
            cart.add(foundProduct);
            System.out.println("Your product is added to the cart. " + foundProduct.getName());
        } else {
            System.out.println("The product is not found in the inventory, please try again ");
        }
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        totalAmount = 0.0;
        System.out.println("Cart ");
        for (Product product : cart) {
            System.out.println("Product id " + product.getId() + "Name " + product.getName() + "Price " + product.getPrice());
            totalAmount += product.getPrice();
        }
        System.out.println("Total amount: " + totalAmount);
        System.out.println("Do you want to remove product from cart? (yes/no)");
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("yes")) {
            if (cart.isEmpty()) {
                System.out.println("There is no product to remove ");
            } else {
                System.out.println("You can remove the product by entering the ID ");
                String id = scanner.nextLine().trim();

                Product productToBeRemoved = findProductById(id);
                if (productToBeRemoved != null) {
                    cart.remove(productToBeRemoved);
                    System.out.println("Product removed from cart " + productToBeRemoved.getName() + "|");
                } else {
                    System.out.println("Product not found in the cart ");
                }
            }
        }
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cart summary " + totalAmount);
        for (Product product : cart) {
            System.out.println();
        }
        System.out.println("Total amount: " + totalAmount);

        System.out.println("Do you want to purchase? Please confirm purchase? (yes/no) ");
        String choice = scanner.nextLine().trim();
        scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Purchase confirmed. Successful! " + totalAmount);
        }else if (choice.equalsIgnoreCase("No")) {
            System.out.println("Checkout cancelled ");
        } else {
            System.out.println("Invalid, enter yes or no ");
        }

    }


    public static Product findProductById(String id) {
        for (Product product : inventory) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        System.out.println(" Product Empty ");
        return null;


    }
}