// # Assignment-1 : Karatsuba Algorithm
// # Square of 20 digit number using divide and conquer method
// # Time : O(n^1.59)
import java.util.Scanner;

public class ass1 {
   public static int karatsuba(int x, int y) {
      if (x < 10) {
         return x * y;
      } else {
         int n = Integer.toString(x).length();
         int h = n / 2;
         int a, b, c, d, ac, bd, plus, p, k;
         p = (int) (Math.pow(10, h));
         k = (int) (Math.pow(10, (h * 2)));
         // Formula : ac*10^(2*n/2) + (ad+bc)*10^(n/2) + bd
         a = x / p;
         b = x % p;
         c = y / p;
         d = y % p;
         ac = karatsuba(a, c);
         bd = karatsuba(b, d);
         plus = karatsuba(a + b, c + d) - (ac + bd);
         return (ac * k + plus * p + bd);
      }
   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter the number: ");
      int x = s.nextInt();
      int res = karatsuba(x, x);
      System.out.println("\nSqaure of " + x + " is: " + res);
      System.out.println();
   }
}
