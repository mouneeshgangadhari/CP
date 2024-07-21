/*
In a classroom of students, each student has a unique identifier within 
the range of [0, n]. However, one student has gone missing, and their absence 
needs to be identified. Write a program that takes in an array of distinct 
student IDs and returns the ID of the missing student.

input format:  an integer (n)
               n number of integers
output format: an integer

Example 1:
Input:3
3 0 1
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the 
range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input:2
0 1
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the 
range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input:9
9 6 4 2 3 5 7 0 1
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the 
range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 
Constraints:
n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
All the numbers of nums are unique.
*/
package bitmanuplication;

import java.util.Scanner;

public class missingnumber {
    public static int help(int[] a, int n) {
        int x = 0;
        for (int i = 0; i <= n; i++) {
            x = x ^ i;
        }
        for (int i = 0; i < n; i++) {
            x = x ^ a[i];
        }
        return x;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        System.out.println(help(a, n));
    }
}
