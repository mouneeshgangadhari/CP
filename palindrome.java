
/*
AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

*/
import java.util.*;

class palindrome {
    public static boolean help(String str) {
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            c = c ^ (1 << (str.charAt(i) - 'a'));
        }
        return (c & (c - 1)) == 0;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(help(str));
    }
}