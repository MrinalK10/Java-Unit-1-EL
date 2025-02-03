import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"JAVA", "CLASS", "OBJECT", "METHOD", "VARIABLE", "INHERITANCE", "INTERFACE", "EXCEPTION", "PACKAGE", "COMPILER"};
        String word = words[random.nextInt(words.length)];
        
        StringBuilder guessedWord = new StringBuilder("_".repeat(word.length()));
        int chances = 10;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman! You have " + chances + " chances.");
        
        while (chances > 0 && !wordGuessed) {
            System.out.println("Current word: " + guessedWord);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && guessedWord.charAt(i) == '_') {
                    guessedWord.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                chances--;
                System.out.println("Wrong guess. You have " + chances + " chances left.");
            } else if (guessedWord.toString().equals(word)) { 
                wordGuessed = true;
                System.out.println("Congratulations! You've guessed the word: " + word);
                break;
            }
        }

        if (!wordGuessed) {
            System.out.println("Game Over! The correct word was: " + word);
        }

        scanner.close();
    }
}
