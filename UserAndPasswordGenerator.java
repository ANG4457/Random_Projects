import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class UserAndPasswordGenerator {

    // Method to generate a random number between min and max (inclusive)
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Method to generate a password with a fixed prefix and random numbers
    private static String generatePassword() {
        int randomNumber = getRandomNumber(100000, 999999); // Generates a random 6-digit number
        return "Password" + randomNumber; // Concatenates the prefix with the random number
    }

    public static void main(String[] args) {
        // Number of passwords to generate
        int numberOfPasswords = 200;

        // StringBuilder to store generated usernames
        StringBuilder userList = new StringBuilder();

        // Generate usernames and add them to the list
        String[] usernames = {"root", "admin", "administrator"};
        for (String username : usernames) {
            userList.append(username).append("\n");
        }

        // Write the username list to a file named "ListOfUsersName.txt"
        try (FileWriter writer = new FileWriter("ListOfUsersName.txt")) {
            writer.write(userList.toString());
            System.out.println("Username list saved to ListOfUsersName.txt");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

        // StringBuilder to store generated passwords
        StringBuilder passwordList = new StringBuilder();

        // Generate one fixed password and add it to the list
        passwordList.append("Password1234560").append("\n");

        // Generate additional passwords and add them to the list
        for (int i = 1; i < numberOfPasswords; i++) {
            passwordList.append(generatePassword()).append("\n");
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
