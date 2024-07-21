
/*
 * Input a number N.
Check whether its binary equivalent is Palindrome or not.

for Example
If N is 9
its binary equivalent is 1001 which is palindrome.

Return true if it is palindrome, false otherwise.

Test Cases
case=1
input=9
output=true

case=2
input=6
output=false
 */

import java.util.*;

public class BinaryPalindrome {
    public static boolean help(int n) {
        int t = n;
        StringBuilder s = new StringBuilder("");
        while (t > 0) {
            int e = t & 1;
            s.append(e);
            t >>= 1;
        }
        String st = s.toString();
        String nn = Integer.toBinaryString(n);
        // System.out.println(nn+" "+st);
        return nn.equals(st);
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(help(n));
    }
}
