/*
You are given a 0-indexed string blocks of length n, 
where blocks[i] is either 'W' or 'B', representing the color of the ith block. 
The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

input format: string 
              an integer(k)
output format : an Integer
 
Example 1:

Input: WBBWWBBWBW
7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW". 
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.

Example 2:
Input:WBWBBBW
2
Output: 0

Explanation:
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.
 

Constraints:

n == blocks.length
1 <= n <= 100
blocks[i] is either 'W' or 'B'.
1 <= k <= n
*/
import java.util.*;
class Solution {
    public int minimumRecolors(String blocks, int k) {
		
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
        }
        int ans = cnt;
		System.out.println("ans " + ans);

        for (int i = k; i < blocks.length(); ++i) 
		{
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(i - k) == 'W' ? 1 : 0;
			System.out.println("cnt " + cnt + " i " + i);
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
	
	public static void main( String[] args)
	{
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		int k = sc.nextInt();
		System.out.println(new Solution().minimumRecolors(str,k));
	}
}
/*
TEST CASES:
case =1
input=WBWBWBWBWBWBWBWBWBWBW
6
output=3
case =2
input=WWWWWWWWWWWWWWWWWWWWWWWWWWWW
5
output=5
case =3
input=BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB
10
output=0
case =4
input=WBWBWWWBWWWWBWWWWBBBBBBWWBBBBBBBBBBBBBBBBBBBBBB
10
output=0
*/