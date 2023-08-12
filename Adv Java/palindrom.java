import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class palindrom {
 
  public static boolean Reverse(String s){
        if (s == null || s.equals(""))
            return false;

        List<Character> list = new ArrayList<Character>();
        for (char c: s.toCharArray()) {
            list.add(c);
        }
        Collections.reverse(list);
        String str = list.stream().map(String::valueOf).collect(Collectors.joining());
        if(str.equals(s))
           return true;
        return false;
  }
  public static void main(String[] args) {
      String s;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter string: ");
      s = input.nextLine();
      boolean ans = Reverse(s);
      if(ans)
        System.out.println( "String "+ s + " is palindrome !" );
      else
      System.out.println( "String " + s + " is not palindrome !" );
  }
}
