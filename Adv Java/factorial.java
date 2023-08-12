// # Factorial of a number

import java.util.Scanner;

public class factorial {
    public static int findFact(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (n < 0)
            return -1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int n;
        int dec;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter number: ");
            n = s.nextInt();
            int ans = findFact(n);
            if (ans == -1) {
                System.out.println("Factorial of a negative number does not exist !");
                return;
            }
            System.out.println("Fcatorial of " + n + " is : " + ans);
            System.out.print("\nAre you want to continue [0/1]: ");
            dec = s.nextInt();
            if (dec == 0) {
                System.out.println("\nProgram Terminated...");
                break;
            }
        }
    }
}