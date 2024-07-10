import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Method to generate a random password
    public static String generatePassword(int length, boolean includeUpperCase, boolean includeNumbers, boolean includeSpecialChars) {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        StringBuilder characterPool = new StringBuilder(lowerCaseLetters);
        if (includeUpperCase) {
            characterPool.append(upperCaseLetters);
        }
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeSpecialChars) {
            characterPool.append(specialChars);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    // Method to suggest a strong password
    public static String suggestStrongPassword() {
        return generatePassword(12, true, true, true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for password criteria
        System.out.println("Password Generator");
        System.out.println("------------------");
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUpperCase = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

        // Generate and display the password based on user requirements
        String password = generatePassword(length, includeUpperCase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        // Suggest a strong password
        String strongPassword = suggestStrongPassword();
        System.out.println("Suggested Strong Password: " + strongPassword);

        scanner.close();
    }
}
