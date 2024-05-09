package com.pluralsight;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.FileNameMap;
import java.sql.Array;
=======
import java.io.FileReader;
import java.io.IOException;
>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

<<<<<<< HEAD
    private static final String FILE_NAME = "products.csv";
    public static ArrayList<Product> inventory = new ArrayList<Product>();
    public static ArrayList<Product> cart = new ArrayList<Product>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize variables
=======
    public static void main(String[] args) {
        // Initialize variables
        ArrayList<Product> inventory = new ArrayList<Product>();
        ArrayList<Product> cart = new ArrayList<Product>();
>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b
        double totalAmount = 0.0;

        // Load inventory from CSV file
        loadInventory("products.csv", inventory);
<<<<<<< HEAD
        boolean running = true;
=======
>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b

        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Display menu and get user choice until they choose to exit
<<<<<<< HEAD
        while (running) {
=======
        while (choice != 3) {
>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
<<<<<<< HEAD
=======

>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b
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
<<<<<<< HEAD
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


=======
    }

    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        // This method should read a CSV file with product information and
        // populate the inventory ArrayList with Product objects. Each line
        // of the CSV file contains product information in the following format:
        //
        // id,name,price
        //
        // where id is a unique string identifier, name is the product name,
        // price is a double value representing the price of the product
    }

    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        // This method should display a list of products from the inventory,
        // and prompt the user to add items to their cart. The method should
        // prompt the user to enter the ID of the product they want to add to
        // their cart. The method should
        // add the selected product to the cart ArrayList.
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        // This method should display the items in the cart ArrayList, along
        // with the total cost of all items in the cart. The method should
        // prompt the user to remove items from their cart by entering the ID
        // of the product they want to remove. The method should update the cart ArrayList and totalAmount
        // variable accordingly.
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        // This method should calculate the total cost of all items in the cart,
        // and display a summary of the purchase to the user. The method should
        // prompt the user to confirm the purchase, and deduct the total cost
        // from their account if they confirm.
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // This method should search the inventory ArrayList for a product with
        // the specified ID, and return the corresponding Product object. If
        // no product with the specified ID is found, the method should return
        // null.
>>>>>>> a9850731488a23ba76fffe44ff89edb2f4a1a45b
    }
}