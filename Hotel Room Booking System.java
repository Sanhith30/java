import java.util.Scanner;

class Hotel {
    boolean[] rooms = new boolean[10];

    public void showStatus() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room " + (i + 1) + ": " + (rooms[i] ? "Booked" : "Free"));
        }
    }

    public void book(int num) {
        if (num < 1 || num > 10) System.out.println("Invalid Room.");
        else if (rooms[num - 1]) System.out.println("Already booked.");
        else {
            rooms[num - 1] = true;
            System.out.println("Booked Room " + num);
        }
    }

    public void checkout(int num) {
        if (num < 1 || num > 10) System.out.println("Invalid Room.");
        else {
            rooms[num - 1] = false;
            System.out.println("Checked out Room " + num);
        }
    }
}

public class HotelSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Status 2. Book 3. Checkout 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            switch (choice) {
                case 1: hotel.showStatus(); break;
                case 2:
                    System.out.print("Room (1-10): ");
                    hotel.book(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Room (1-10): ");
                    hotel.checkout(sc.nextInt());
                    break;
            }
        }
        sc.close();
    }
}
