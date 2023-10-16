package Lab01;

import java.util.Scanner;
public class SolveEquations1{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                solveFirstDegreeOneVariable(sc);
                break;
            case 2:
                solveFirstDegreeTwoVariables(sc);
                break;
            case 3:
                solveSecondDegreeOneVariable(sc);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }

    // Solve a first-degree equation with one variable
    public static void solveFirstDegreeOneVariable(Scanner sc) {
        System.out.println("Enter the coefficients a and b of the equation ax + b = 0");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution of the equation is x = " + x);
        }
    }

    // Solve a system of first-degree equations with two variables
    public static void solveFirstDegreeTwoVariables(Scanner sc) {
        System.out.println("Enter the coefficients a11, a12, b1, a21, a22, b2 of the system:");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        // Calculate the determinants
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions");
            } else {
                System.out.println("The system has no solution");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution of the system is x1 = " + x1 + ", x2 = " + x2);
        }
    }

    // Solve a second-degree equation with one variable
    public static void solveSecondDegreeOneVariable(Scanner sc) {
        System.out.println("Enter the coefficients a, b, c of the equation ax^2 + bx + c = 0");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a == 0) {
            // Reduce to first-degree equation
            solveFirstDegreeOneVariable(sc);
        } else {
            // Calculate the discriminant
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                System.out.println("The equation has no real root");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has two distinct roots x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}
