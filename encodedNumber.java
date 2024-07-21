/*
 * Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.

Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000

Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
 */

import java.util.Scanner;

public class encodedNumber {
    public static String help(int n) {
        if (n == 0) {
            return " ";
        }
        n = n + 1;
        StringBuilder str = new StringBuilder();
        while (n != 1) {
            str.append(n & 1);
            n = n >> 1;
        }
        return str.reverse().toString();
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(help(n));
    }
}
