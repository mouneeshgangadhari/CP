
/*
Given two integers a and b, return the sum of the two integers without using the operators +.
Example 1:
Input=1  2
Output=3 

Example 2:
Input=2 3
Output=5
*/
package bitmanuplication;

import java.util.Scanner;

public class getsum {
    public static int help(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(help(a, b));
    }
}
