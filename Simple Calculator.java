import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Num1: "); double a = sc.nextDouble();
        System.out.print("Operator (+,-,*,/): "); char op = sc.next().charAt(0);
        System.out.print("Num2: "); double b = sc.nextDouble();
        
        if (op == '+') System.out.println(a + b);
        else if (op == '-') System.out.println(a - b);
        else if (op == '*') System.out.println(a * b);
        else if (op == '/') System.out.println(b != 0 ? a / b : "Error");
        sc.close();
    }
}
