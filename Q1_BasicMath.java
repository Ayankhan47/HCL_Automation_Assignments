import java.util.Scanner;

public class Q1_BasicMath {

    static double add(double a, double b)       { return a + b; }
    static double subtract(double a, double b)  { return a - b; }
    static double multiply(double a, double b)  { return a * b; }

    static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    static double remainder(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot find remainder with zero");
        return a % b;
    }

    static double square(double a)   { return a * a; }
    static double cube(double a)     { return a * a * a; }
    static double absolute(double a) { return (a < 0) ? -a : a; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== BASIC MATHS =====");
            System.out.println("1. Addition      2. Subtraction");
            System.out.println("3. Multiplication 4. Division");
            System.out.println("5. Remainder     6. Square");
            System.out.println("7. Cube          8. Absolute");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                if (choice >= 1 && choice <= 5) {
                    System.out.print("Enter two numbers: ");
                    double a = sc.nextDouble(), b = sc.nextDouble();
                    switch (choice) {
                        case 1: System.out.println("Sum = " + add(a, b)); break;
                        case 2: System.out.println("Difference = " + subtract(a, b)); break;
                        case 3: System.out.println("Product = " + multiply(a, b)); break;
                        case 4: System.out.println("Quotient = " + divide(a, b)); break;
                        case 5: System.out.println("Remainder = " + remainder(a, b)); break;
                    }
                } else if (choice >= 6 && choice <= 8) {
                    System.out.print("Enter a number: ");
                    double a = sc.nextDouble();
                    switch (choice) {
                        case 6: System.out.println("Square = " + square(a)); break;
                        case 7: System.out.println("Cube = " + cube(a)); break;
                        case 8: System.out.println("Absolute = " + absolute(a)); break;
                    }
                } else if (choice != 0) {
                    System.out.println("Invalid choice!");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
        System.out.println("Goodbye!");
        sc.close();
    }
}
