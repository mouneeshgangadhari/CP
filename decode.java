/*
 * 
Mr.Bond is a spy he sent an encoded message to Ms.M, which is an array of integers. 
she needs to decode that array to original array. 
Bond sends encoded array and an integer which should be the first number in the 
resultant decoded array.
With your programming skills can you write a program for this decoding. 

Bond encoded original array into another integer array  of length n - 1, such 
that encoded[i] = arr[i] XOR arr[i + 1]. 

For example, if arr = [1,0,2,1], then encoded = [1,2,3].

input format :an integer n 
              encoded array with n number of integers
			  an integer first
output format : decoded array with n+1 number of integers

You are given the encoded array. You are also given an integer first, that is 
the first element of arr, i.e. arr[0].

Return the original array arr. It can be proved that the answer exists and is unique.

 

Example 1:

Input: encoded = [1,2,3], first = 1
Output: [1,0,2,1]
Explanation: If arr = [1,0,2,1], then first = 1 and encoded = 
[1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
Example 2:

Input: encoded = [6,2,7,3], first = 4
Output: [4,2,0,7,4]
 

Constraints:

2 <= n <= 103
decoded.length == n + 1
0 <= encoded[i] <= 105
0 <= first <= 105

 */
package bitmanuplication;

import java.util.*;

public class decode {
    public static int[] help(int[] a, int n, int k) {
        int[] res = new int[n + 1];
        res[0] = k;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] ^ a[i - 1];
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
        int k = sc.nextInt();
        System.out.println(Arrays.toString(help(a, n, k)));
    }
}
