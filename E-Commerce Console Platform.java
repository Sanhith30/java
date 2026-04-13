import java.util.*;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class User {
    String username, password;
    List<Product> cart = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class EStoreSystem {
    private static List<Product> catalog = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        while (true) {
            if (currentUser == null) {
                System.out.println("\n--- Welcome to E-Store ---");
                System.out.println("1. Login\n2. Register\n3. Exit");
                int choice = sc.nextInt();
                if (choice == 1) login();
                else if (choice == 2) register();
                else break;
            } else {
                showMenu();
            }
        }
    }

    private static void initData() {
        catalog.add(new Product(101, "Laptop", 800.0));
        catalog.add(new Product(102, "Phone", 500.0));
        catalog.add(new Product(103, "Headphones", 50.0));
    }

    private static void register() {
        System.out.print("Username: "); String u = sc.next();
        System.out.print("Password: "); String p = sc.next();
        users.add(new User(u, p));
        System.out.println("Registration successful!");
    }

    private static void login() {
        System.out.print("Username: "); String u = sc.next();
        System.out.print("Password: "); String p = sc.next();
        for (User user : users) {
            if (user.username.equals(u) && user.password.equals(p)) {
                currentUser = user;
                System.out.println("Logged in as " + u);
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    private static void showMenu() {
        System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                for (Product p : catalog) System.out.println(p.id + ". " + p.name + " - $" + p.price);
                break;
            case 2:
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                for (Product p : catalog) {
                    if (p.id == id) {
                        currentUser.cart.add(p);
                        System.out.println("Added to cart.");
                        return;
                    }
                }
                System.out.println("Product not found.");
                break;
            case 3:
                double total = 0;
                for (Product p : currentUser.cart) {
                    System.out.println(p.name + " - $" + p.price);
                    total += p.price;
                }
                System.out.println("Total: $" + total);
                break;
            case 4:
                System.out.println("Payment successful. Shipping items!");
                currentUser.cart.clear();
                break;
            case 5:
                currentUser = null;
                break;
        }
    }
}
