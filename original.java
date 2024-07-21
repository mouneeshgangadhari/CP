/* 

Mr.Balu is working on arrays, a modified array pref is given to him, 
he has to print an original array from which this modified array is prepared.

Modification of original array is as follows.
pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
Note that ^ denotes the bitwise-xor operation.

It can be proven that the answer is unique.

Input format : an integer n
               an array of n integers
output fromat : an array of n integers

Example 1:

Input: pref = [5,2,0,3,1]
Output: [5,7,2,3,2]
Explanation: From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
Example 2:

Input: pref = [13]
Output: [13]
Explanation: We have pref[0] = arr[0] = 13.
 

Constraints:

1 <= pref.length <= 105
0 <= pref[i] <= 106
*/
package bitmanuplication;

import java.util.*;

public class original {
    public static int[] help(int[] a, int n) {
        int[] res = new int[n];
        res[0] = a[0];
        for (int i = 1; i < n; i++) {
            res[i] = a[i] ^ a[i - 1];
        }
        return res;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(help(a, n)));
    }
}
