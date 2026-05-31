package com.math.operations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MathOperations obj = new MathOperations();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Addition: " + obj.add(a, b));
        System.out.println("Subtraction: " + obj.subtract(a, b));

        sc.close();
    }
}