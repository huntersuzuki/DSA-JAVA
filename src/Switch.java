import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
//        int opt = 4;
//        switch (opt) {
//            case 1:
//                System.out.println("You selected English language");
//                break;
//            case 2:
//                System.out.println("You selected Marathi language");
//                break;
//                case 3:
//                    System.out.println("You selected Spanish language");
//                    break;
//            default:
//                System.out.println("You selected Invalid option");
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        int x = sc.nextInt();
        System.out.println("Enter second number");
        int y = sc.nextInt();
        int result = 0;
        System.out.println("Enter +,-,*,/");
        char ch = sc.next().charAt(0);
        switch (ch){
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case  '/':
                result = x / y;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        System.out.println("Result: "+result);
    }
}
