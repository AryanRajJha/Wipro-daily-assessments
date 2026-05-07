package Assessments;

import java.util.Scanner;

class pr1_employee {
    private double salary;

    public boolean setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            return true;
        } else {
            System.out.println("Invalid salary");
            return false;
        }
    }

    public double getSalary() {
        return salary;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pr1_employee emp = new pr1_employee();

        System.out.print("Enter salary: ");
        double sal = sc.nextDouble();

        if (emp.setSalary(sal)) {
            System.out.println("Salary: " + emp.getSalary());
        }

        sc.close();
    }
}