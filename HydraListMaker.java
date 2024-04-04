import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HydraListMaker{
    private static final String USERNAME_FILE = "Users.txt";
    private static final String PASSWORD_FILE = "PasswordListv2.txt";
    private static final String[] SHORT_WORDS = {"apple", "banana", "cat", "dog", "sun", "moon", "star", "rain"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of usernames you want to generate: ");
        int numUsernames = scanner.nextInt();
        generateUsernames(numUsernames);
        
        System.out.print("Enter the number of passwords you want to generate: ");
        int numPasswords = scanner.nextInt();
        generatePasswords(numPasswords);
        
        scanner.close();
    }

    private static void generateUsernames(int numUsernames) {
        try {
            FileWriter writer = new FileWriter(USERNAME_FILE);
            Random random = new Random();

            for (int i = 0; i < numUsernames; i++) {
                StringBuilder username = new StringBuilder();
                for (int j = 0; j < 15; j++) {
                    int choice = random.nextInt(3);
                    switch (choice) {
                        case 0: // A-Z
                            username.append((char) (random.nextInt(26) + 'A'));
                            break;
                        case 1: // a-z
                            username.append((char) (random.nextInt(26) + 'a'));
                            break;
                        case 2: // 0-9
                            username.append(random.nextInt(10));
                            break;
                    }
                }
                writer.write(username.toString() + "\n");
            }
            writer.close();
            System.out.println(numUsernames + " usernames generated successfully and saved to " + USERNAME_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generatePasswords(int numPasswords) {
        try {
            FileWriter writer = new FileWriter(PASSWORD_FILE);
            Random random = new Random();

            for (int i = 0; i < numPasswords; i++) {
                StringBuilder password = new StringBuilder();
                for (int j = 0; j < 10 + random.nextInt(11); j++) {
                    int choice = random.nextInt(4);
                    switch (choice) {
                        case 0: // A-Z
                            password.append((char) (random.nextInt(26) + 'A'));
                            break;
                        case 1: // a-z
                            password.append((char) (random.nextInt(26) + 'a'));
                            break;
                        case 2: // 0-9
                            password.append(random.nextInt(10));
                            break;
                        case 3: // Special characters and short words
                            if (j < 6) { // Ensure at least half of the password length is random characters
                                password.append(SHORT_WORDS[random.nextInt(SHORT_WORDS.length)]);
                            } else {
                                password.append("!@#$%^&*()".charAt(random.nextInt("!@#$%^&*()".length())));
                            }
                            break;
                    }
                }
                writer.write(password.toString() + "\n");
            }
            writer.close();
            System.out.println(numPasswords + " passwords generated successfully and saved to " + PASSWORD_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
