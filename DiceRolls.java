/*
There are a group of n kids playing with dice, 
and each dice has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the k*n total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:
----------
Input=
1
6
3
Output=
1

Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.

Example 2:
----------
Input=
2
6
7
Output=
6

Explanation: You throw two dice, each with 6 faces.
There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Example 3:
----------
Input= 
30
30
500
Output=
222616187

Explanation: The answer must be returned modulo 10^9 + 7.

Constraints:
1 <= n, k <= 30
1 <= target <= 1000
*/
import java.util.*;
class Solution {
    int[][] dp;
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if (n == 0 && target == 0) 
            return 1;
        if (target < n || n * k < target) 
            return 0;
        dp = new int[n + 1][target + 1];
        return f(n, k, target);
    }
    public int f(int n, int k, int target) {
        if (n == 0 && target == 0){
            return 1;
        }
        if (target < n || n * k < target) {
            return 0;
        }
        if (dp[n][target] != 0) {
            return dp[n][target];
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (target < i) break;
                res = (res + f(n - 1, k, target - i) % MOD) % MOD;
        }
        dp[n][target] = res;
        return res;
    }
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt(),t=sc.nextInt();
		System.out.println(new Solution().numRollsToTarget(n,k,t));
	}
}
/* Test cases
case=1
Input=
1
6
3
Output=
1

case=2
Input=
2
6
7
Output=
6

case=3
Input= 
30
30
500
Output=
222616187

case=4
Input=15
8
26
Output=4447200

case=5
Input=25
25
125
Output=102318898
*/
