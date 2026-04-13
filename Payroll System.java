import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateSalary();

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: $" + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary - (monthlySalary * 0.15); 
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return (hoursWorked * hourlyRate);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Full-Time 2. Add Part-Time 3. View All 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            System.out.print("ID: "); int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: "); String name = sc.nextLine();

            if (choice == 1) {
                System.out.print("Monthly Salary: ");
                employees.add(new FullTimeEmployee(name, id, sc.nextDouble()));
            } else if (choice == 2) {
                System.out.print("Hours Worked: "); int hours = sc.nextInt();
                System.out.print("Hourly Rate: "); double rate = sc.nextDouble();
                employees.add(new PartTimeEmployee(name, id, hours, rate));
            } else if (choice == 3) {
                for (Employee e : employees) e.display();
            }
        }
        sc.close();
    }
}
