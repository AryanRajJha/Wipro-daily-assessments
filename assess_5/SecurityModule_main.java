package assess_5;

import java.util.Base64;
import java.util.Scanner;

final class SecurityModule {

    
    private SecurityModule() {}

    
    public static String encryptData(String data) {
        validate(data);

        String encoded = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println("Data encrypted successfully.");
        return encoded;
    }

    public static String decryptData(String encryptedData) {
        validate(encryptedData);

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        return new String(decodedBytes);
    }

    private static void validate(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty.");
        }
    }
}

public class SecurityModule_main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter data to encrypt: ");
            String data = sc.nextLine();

            String encrypted = SecurityModule.encryptData(data);
            System.out.println("Encrypted Data: " + encrypted);

            String decrypted = SecurityModule.decryptData(encrypted);
            System.out.println("Decrypted Data: " + decrypted);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}