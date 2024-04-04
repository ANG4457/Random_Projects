import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PasswordGenerator {

    // Method to generate a random number between min and max (inclusive)
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Method to generate a password with a fixed prefix and random numbers
    private static String generatePassword(String prefix) {
        int randomNumber = getRandomNumber(100000, 999999); // Generates a random 6-digit number
        return prefix + randomNumber; // Concatenates the prefix with the random number
    }

    public static void main(String[] args) {
        // Number of passwords to generate
        int numberOfPasswords = 100;

        // Prefix for the passwords
        String passwordPrefix = "Password";

        // StringBuilder to store generated passwords
        StringBuilder passwordList = new StringBuilder();

        // Generate passwords and add them to the list
        for (int i = 0; i < numberOfPasswords; i++) {
            passwordList.append(generatePassword(passwordPrefix)).append("\n");
        }

        // Write the password list to a file named "passwordList.txt"
        try (FileWriter writer = new FileWriter("passwordList.txt")) {
            writer.write(passwordList.toString());
            System.out.println("Password list saved to passwordList.txt");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
