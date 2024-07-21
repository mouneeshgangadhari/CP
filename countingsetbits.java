/*
 * Write a Java program to count the number of bits set to 1 (set bits) of an integer.

Example 1=
input=5
output=2

Example 2=
input=15
output=4

Example 3=
input=127
output=7
 */

import java.util.Scanner;

public class countingsetbits {
    public static int help(int n) {
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                c++;
            }
            // System.out.println(c);
            n = n >>> 1;
        }
        return c;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(help(n));
    }
}
