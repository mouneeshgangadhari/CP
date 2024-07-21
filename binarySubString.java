
/*
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

Example 1:
Input:00110110
2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input:0110
1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
Example 3:

Input:0110
2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
 

Constraints:

1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20

 */
import java.util.*;

public class binarySubString {
    public static boolean areAllPresent(String s, int t) {
        int n = (int) Math.pow(2, t);
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < s.length() - t; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + t; j++) {
                sb.append(s.charAt(j));
            }
            hs.add(sb.toString());
        }
        for (String x : hs) {
            System.out.print(x + " ");
        }
        return hs.size() == n;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t = sc.nextInt();
        System.out.println(areAllPresent(s, t));
    }
}
