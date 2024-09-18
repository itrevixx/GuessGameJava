import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean running = true;

        while (running) {
            // Generar un nuevo número secreto para cada nuevo juego
            Random random = new Random();
            int secretNumber = random.nextInt(100) + 1;

            System.out.println("Please select the difficulty level");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");

            System.out.print("Enter your choice: ");
            int option = Integer.parseInt(br.readLine());

            int attempts = 0;

            switch (option) {
                case 1:
                    System.out.println("Great! You have selected the Easy difficulty level.");
                    attempts = 10;
                    break;
                case 2:
                    System.out.println("Great! You have selected the Medium difficulty level.");
                    attempts = 5;
                    break;
                case 3:
                    System.out.println("Great! You have selected the Hard difficulty level.");
                    attempts = 3;
                    break;
                default:
                    System.out.println("Invalid option!");
                    continue; // Volver al inicio del bucle para elegir la dificultad nuevamente
            }

            System.out.println("Let's start the game!");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Enter your guess: ");
                int guess = Integer.parseInt(br.readLine());
                if (secretNumber == guess) {
                    System.out.println("Congratulations! You guessed the correct number in "+i+" attempts.");
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                // Si es el último intento y no ha adivinado
                if (i == attempts) {
                    System.out.println("Too bad! The number was " + secretNumber);
                }
            }

            System.out.println("Do you want to play again (yes/no)");
            String playAgain = br.readLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                running = false;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
