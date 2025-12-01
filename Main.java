import java.util.Scanner;

public class Main {
    static String[] words = {"java", "python", "hangman", "programming", "computer"};
    static String word = words[(int)(Math.random() * words.length)];
    static char[] display = new char[word.length()];
    static int lives = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < display.length; i++) display[i] = '_';

        System.out.println("=== Hangman ===");
        while (lives > 0 && String.valueOf(display).contains("_")) {
            System.out.println("\nWord: " + String.valueOf(display));
            System.out.println("Lives: " + "♥ ".repeat(lives));
            System.out.print("Guess a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    display[i] = guess;
                    found = true;
                }
            }
            if (!found) {
                lives--;
                System.out.println("Wrong guess!");
            }
        }

        if (lives > 0) System.out.println("You win! Word was: " + word);
        else System.out.println("Game Over! Word was: " + word);
    }
}