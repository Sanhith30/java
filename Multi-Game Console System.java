import java.util.Scanner;
import java.util.Random;

class GuessGame {
    public void start() {
        Scanner sc = new Scanner(System.in);
        int target = new Random().nextInt(100) + 1;
        int guess = 0;

        System.out.println("Guess a number between 1 and 100");

        while (guess != target) {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();
            if (guess < target) System.out.println("Too low!");
            else if (guess > target) System.out.println("Too high!");
            else System.out.println("Correct! You win.");
        }
    }
}

class WordPuzzle {
    public void start() {
        Scanner sc = new Scanner(System.in);
        String word = "JAVA";
        String scramble = "VAJA";
        String input = "";

        System.out.println("Unscramble the word: " + scramble);

        while (!input.equalsIgnoreCase(word)) {
            System.out.print("Your answer: ");
            input = sc.next();
            if (!input.equalsIgnoreCase(word)) System.out.println("Try again!");
        }
        System.out.println("Solved!");
    }
}

public class GameSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Guess Number 2. Word Puzzle 3. Exit");
            int choice = sc.nextInt();
            if (choice == 3) break;

            if (choice == 1) new GuessGame().start();
            else if (choice == 2) new WordPuzzle().start();
        }
        sc.close();
    }
}
