import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String position;
    double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void show() {
        System.out.println("ID: " + id + " | Name: " + name + " | Post: " + position + " | Salary: $" + salary);
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add 2. View All 3. Search 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Position: "); String p = sc.nextLine();
                    System.out.print("Salary: "); double s = sc.nextDouble();
                    list.add(new Employee(id, n, p, s));
                    break;
                case 2:
                    for (Employee e : list) e.show();
                    break;
                case 3:
                    System.out.print("Search ID: ");
                    int sid = sc.nextInt();
                    for (Employee e : list) if (e.id == sid) e.show();
                    break;
            }
        }
        sc.close();
    }
}
