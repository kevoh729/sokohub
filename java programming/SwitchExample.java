import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println("Enter option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Sum: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Difference: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Product: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Quotient: " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid option");
        }

    }
    
}
