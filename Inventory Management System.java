import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Qty: " + quantity + " | Price: $" + price);
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added.");
    }

    public void updateStock(int id, int newQty) {
        for (Product p : products) {
            if (p.id == id) {
                p.quantity = newQty;
                System.out.println("Stock updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void showInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : products) p.display();
    }

    public void deleteProduct(int id) {
        if (products.removeIf(p -> p.id == id)) {
            System.out.println("Product removed.");
        } else {
            System.out.println("ID not found.");
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Add 2. Update Stock 3. View All 4. Delete 5. Exit");
            System.out.print("Select: ");
            choice = sc.nextInt();

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Qty: "); int qty = sc.nextInt();
                    System.out.print("Price: "); double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("ID: "); int uid = sc.nextInt();
                    System.out.print("New Qty: "); int uqty = sc.nextInt();
                    inv.updateStock(uid, uqty);
                    break;
                case 3:
                    inv.showInventory();
                    break;
                case 4:
                    System.out.print("ID: "); int did = sc.nextInt();
                    inv.deleteProduct(did);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
