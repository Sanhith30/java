import java.util.*;

class Question {
    String prompt, answer;
    public Question(String p, String a) { prompt = p; answer = a; }
}

public class ExamSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> bank = new ArrayList<>();
        bank.add(new Question("Java is a: A) Language B) Fruit", "A"));
        bank.add(new Question("Which one is a primitive? A) String B) Int", "B"));

        System.out.print("Enter Username: "); String user = sc.next();
        System.out.println("Welcome, " + user + "! Start the exam.");

        int score = 0;
        for (int i = 0; i < bank.size(); i++) {
            System.out.println("\nQ" + (i + 1) + ": " + bank.get(i).prompt);
            System.out.print("Ans: ");
            if (sc.next().equalsIgnoreCase(bank.get(i).answer)) score++;
        }

        System.out.println("\n--- Result ---");
        System.out.println("User: " + user);
        System.out.println("Score: " + score + "/" + bank.size());
        sc.close();
    }
}
