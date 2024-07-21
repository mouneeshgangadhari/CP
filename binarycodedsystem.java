/*
 * Given a integer value N, indicates number of bits in a binary number.
Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.
Find and print the integer values of BCS, starting from 0.
Note : use bitmanipulation techniques only

Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 

Sample Input-1:
---------------
2
Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3
Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

Constraints:
1 <= n <= 16
 */
package bitmanuplication;

import java.util.Arrays;
import java.util.Scanner;

public class binarycodedsystem {
    public static int[] help(int n) {
        int[] a = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            a[i] = i ^ (i >> 1);
        }
        return a;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Arrays.toString(help(n)));
    }
}
