import java.util.Scanner;

public class Array_Search {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int[] arr = new int[]{4, 10, 4, 5, 3, 8, 10, 4, 7, 3};
        int x;
        System.out.print("Enter the number you want to enter: ");
        x = sc.nextInt();
        int match = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            match = arr[i];
            if (match == x){
                System.out.println("Your number was fond at "+i+" position");
            }
//            else {
//                System.out.println("Your number is not present");
//            }

        }
    }
}
