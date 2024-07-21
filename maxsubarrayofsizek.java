
/*There is an integer array of N heights. You have to pick a certain number of heights
from the array every time. Find the maximum  sum of all the heights picked 
every time that meets the following conditions:
    - The length of the subarray is L, and
    - All the heights of the subarray picked are distinct.

Return the maximum subarray sum of all the height subarrays that meet the 
conditions. If no heights subarray meets the conditions, return 0.

- A subarray is a contiguous non-empty sequence of elements within an array.

Input Format:
-------------
Line-1: Two space separated integers, N and L
Line-2: N space separated integers, height[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 3
7 7 7 1 5 4 2

Sample Output-1:
----------------
13

Explanation: 
------------
The subarrays of length 3 of height array are:
    - [7,7,7] this subarray does not meet the requirement because the 7 is repeated.
    - [7,7,1] this subarray does not meet the requirement because the 7 is repeated.
    - [7,1,5] this subarray meets the requirements and its sum is 13.
    - [1,5,4] this subarray meets the requirements and its sum is 10.
    - [5,4,2] this subarray meets the requirements and its sum is 11. 

Return 13 because it is the maximum subarray sum of all the subarrays 
that meet the conditions


Sample Input-2:
---------------
3 3
7 7 7

Sample Output-2:
----------------
0

Explanation:
------------
The subarrays of length 3 of height array are:
- [7,7,7] which does not meet the requirements because the element 7 is repeated.

Return 0 because no subarrays meet the conditions.
/*
=== testcases ===
case =1
input =7 3
1 5 4 2 9 9 9
output =15

case=2
input=3 3
4 4 4
output=0

case=3

input=7 3
1 2 3 4 5 6 7
output=18

case=4
input=30 5
18 3 16 9 18 17 8 8 9 13 9 7 5 7 9 9 8 10 19 15 7 5 20 11 5 4 15 11 3 12
output=68

case=5
input=50 8
37 35 22 4 46 22 2 48 44 18 31 31 42 36 21 14 9 28 43 29 34 43 9 9 31 48 23 10 29 39 41 12 25 17 40 28 10 39 19 26 3 34 42 23 22 33 33 31 7 27
output=233

case=6
input=15 5
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
output=65

case=7
input=14 4
11 22 33 44 55 66 77 88 99 100 111 123 145 156
output=535

case=8
input=100 9
174 193 71 71 60 182 77 41 110 7 110 98 172 123 40 196 33 69 19 36 36 30 180 49 106 7 48 89 155 130 102 148 19 195 154 21 80 115 112 168 124 43 178 42 53 142 151 108 155 140 20 122 105 138 58 26 107 39 152 34 60 36 191 70 47 123 140 200 159 22 59 78 62 4 44 131 13 29 35 38 80 175 89 130 31 174 187 4 117 49 108 160 29 109 173 87 174 91 156 25
output=1087

*/
import java.util.*;

class Test {
    public static int help(int[] a, int n, int k) {
        Map<Integer, Integer> m1 = new HashMap<>();
        int c = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (!m1.containsKey(a[i])) {
                m1.put(a[i], 0);
            }
            m1.put(a[i], m1.get(a[i]) + 1);
            c = c + a[i];
            if (i >= k - 1) {
                if (m1.size() == k) {
                    max = Math.max(max, c);
                }
                c = c - a[i - k + 1];
                m1.put(a[i - k + 1], m1.get(a[i - k + 1]) - 1);
                if (m1.get(a[i - k + 1]) == 0) {
                    m1.remove(a[i - k + 1]);
                }
            }
        }

        return max;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(help(a, n, k));
    }
}