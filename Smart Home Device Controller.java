import java.util.Scanner;

class Device {
    String name;
    boolean isOn = false;

    public Device(String n) { name = n; }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Device[] home = { new Device("Living Room Light"), new Device("Air Conditioner"), new Device("Smart TV") };
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Home Dashboard ---");
            for (int i = 0; i < home.length; i++) {
                System.out.println((i + 1) + ". " + home[i].name + " [" + (home[i].isOn ? "ON" : "OFF") + "]");
            }
            System.out.println("4. Exit");
            
            System.out.print("Select Device: ");
            int choice = sc.nextInt();
            if (choice == 4) break;

            if (choice >= 1 && choice <= 3) {
                home[choice - 1].isOn = !home[choice - 1].isOn;
                System.out.println(home[choice - 1].name + " toggled.");
            } else {
                System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}
