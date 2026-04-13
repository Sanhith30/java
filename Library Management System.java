import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author);
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library empty.");
            return;
        }
        for (Book b : books) b.display();
    }

    public void findBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                b.display();
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void deleteBook(int id) {
        if (books.removeIf(b -> b.id == id)) {
            System.out.println("Book removed.");
        } else {
            System.out.println("ID not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Add 2. Show 3. Find 4. Delete 5. Exit");
            choice = sc.nextInt();

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    lib.addBook(new Book(id, t, a));
                    break;
                case 2:
                    lib.showBooks();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    lib.findBook(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    lib.deleteBook(sc.nextInt());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
