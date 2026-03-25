import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        int choice;

        System.out.println("Welcome to Student Management System");

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Display Students with Marks Above X");
            System.out.println("5. Calculate Average Marks");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Update Student Record");
            System.out.println("8. Delete Student Record");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                // add student
                Student s = new Student();
                s.inputDetails();
                list.add(s);
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                // display all students
                if (list.size() == 0) {
                    System.out.println("No students found.");
                } else {
                    System.out.println("\n--- All Students ---");
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).displayDetails();
                    }
                }

            } else if (choice == 3) {
                // search by id
                System.out.print("Enter Student ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).studentId == id) {
                        list.get(i).displayDetails();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + id + " not found.");
                }

            } else if (choice == 4) {
                // students with marks above x
                System.out.print("Enter minimum marks: ");
                double minMarks = sc.nextDouble();
                boolean found = false;
                System.out.println("\nStudents with marks above " + minMarks + ":");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).marks > minMarks) {
                        list.get(i).displayDetails();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No students found with marks above " + minMarks);
                }

            } else if (choice == 5) {
                // calculate average marks
                if (list.size() == 0) {
                    System.out.println("No students available.");
                } else {
                    double total = 0;
                    for (int i = 0; i < list.size(); i++) {
                        total = total + list.get(i).marks;
                    }
                    double avg = total / list.size();
                    System.out.println("Total Students : " + list.size());
                    System.out.println("Average Marks  : " + avg);
                }

            } else if (choice == 6) {
                // sort by marks (bubble sort)
                if (list.size() == 0) {
                    System.out.println("No students to sort.");
                } else {
                    // bubble sort
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = 0; j < list.size() - i - 1; j++) {
                            if (list.get(j).marks > list.get(j + 1).marks) {
                                Student temp = list.get(j);
                                list.set(j, list.get(j + 1));
                                list.set(j + 1, temp);
                            }
                        }
                    }
                    System.out.println("Students sorted by marks (ascending):");
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).displayDetails();
                    }
                }

            } else if (choice == 7) {
                // update student record
                System.out.print("Enter Student ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).studentId == id) {
                        found = true;
                        System.out.println("What do you want to update?");
                        System.out.println("1. Name");
                        System.out.println("2. Age");
                        System.out.println("3. Course");
                        System.out.println("4. Marks");
                        System.out.print("Enter choice: ");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        if (opt == 1) {
                            System.out.print("Enter new name: ");
                            list.get(i).name = sc.nextLine();
                        } else if (opt == 2) {
                            System.out.print("Enter new age: ");
                            list.get(i).age = sc.nextInt();
                        } else if (opt == 3) {
                            System.out.print("Enter new course: ");
                            list.get(i).course = sc.nextLine();
                        } else if (opt == 4) {
                            System.out.print("Enter new marks: ");
                            list.get(i).marks = sc.nextDouble();
                        } else {
                            System.out.println("Invalid option.");
                        }
                        System.out.println("Record updated successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + id + " not found.");
                }

            } else if (choice == 8) {
                // delete student record
                System.out.print("Enter Student ID to delete: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).studentId == id) {
                        list.remove(i);
                        System.out.println("Student record deleted successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + id + " not found.");
                }

            } else if (choice == 9) {
                System.out.println("Exiting... Goodbye!");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}
