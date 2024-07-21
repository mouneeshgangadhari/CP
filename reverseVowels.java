/*
Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle


Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class reverseVowels {
    public static String help(String str) {
        StringBuilder s1 = new StringBuilder(str);
        List<Character> al = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            char x = str.charAt(i);
            char y = str.charAt(j);
            if (al.contains(x) && al.contains(y)) {
                s1.setCharAt(i, y);
                s1.setCharAt(j, x);
                i++;
                j--;
            } else if (al.contains(x) && !al.contains(y)) {
                j--;
            } else if (!al.contains(x) && al.contains(y)) {
                i++;
            } else {
                i++;
                j--;
            }

        }
        return s1.toString();
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // Changed from s.next() to sc.next()
        System.out.println(help(str));
    }
}
