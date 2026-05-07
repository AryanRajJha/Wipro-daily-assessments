package Assessments;

import java.util.Scanner;

final class SecurityModule {

    public String encrypt(String data) {
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char)(c + 3));
        }
        return result.toString();
    }

    public String decrypt(String data) {
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char)(c - 3));
        }
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecurityModule sm = new SecurityModule();

        System.out.println("=== Security Module ===");
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        String encrypted = sm.encrypt(msg);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = sm.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}