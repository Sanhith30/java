import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String text, ans;
    String[] opts;

    public Question(String t, String[] o, String a) {
        text = t; opts = o; ans = a;
    }
}

public class QuizSystem {
    public static void main(String[] args) {
        ArrayList<Question> quiz = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Question 2. Take Quiz 3. Exit");
            int c = sc.nextInt(); sc.nextLine();
            if (c == 3) break;
            if (c == 1) {
                System.out.print("Question: "); String q = sc.nextLine();
                String[] op = new String[4];
                for (int i = 0; i < 4; i++) {
                    System.out.print("Opt " + (i + 1) + ": "); op[i] = sc.nextLine();
                }
                System.out.print("Correct Ans: "); quiz.add(new Question(q, op, sc.nextLine()));
            } else if (c == 2) {
                int score = 0;
                for (Question q : quiz) {
                    System.out.println(q.text);
                    for (int i = 0; i < 4; i++) System.out.println((i + 1) + ". " + q.opts[i]);
                    if (sc.nextLine().equalsIgnoreCase(q.ans)) score++;
                }
                System.out.println("Score: " + score + "/" + quiz.size());
            }
        }
        sc.close();
    }
}
