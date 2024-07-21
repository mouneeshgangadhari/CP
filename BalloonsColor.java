/*

You are decorating a wall with two colored balloons 'R'(red) and 'W'(White). You have a magic pencil with which you can change the balloon color from 'R' to 'W' or 'W' to 'R'. Now you will be given a list of initial formation of balloon colors and an integer K, now by using pencil, K number of times change the balloon formation to maximum number of consecutive 'R's or 'W's. Return that maximum number.

Note : you may follow any approach.

input format :	String 
				an integer
output format : an integer

Example 1:
Input=RRWW
2
Output: 4
Explanation: We can replace both the 'W's with 'R's to make sequence = "RRRR".
There are four consecutive 'R's.

Example 2:
Input=RWWR
1
Output: 3
Explanation: We can replace the first 'R' with a 'W' to make sequence = "WWWR".
Alternatively, we can replace the second 'R' with an 'W' to make sequence = "RWWW".
In both cases, there are three consecutive 'W's.

Example 3:
Input=RRWRRWRR
1
Output=5
Explanation: We can replace the first 'W' to make sequence = "RRRRRWRR"
Alternatively, we can replace the second 'W' to make sequence = "RRWRRRRR". 
In both cases, there are five consecutive 'R's.
 

Constraints:

n == sequence.length
1 <= n <= 5 * 104
sequence[i] is either 'R' or 'W'
1 <= k <= n




*/
import java.util.*;
class Solution {
    public int maxConsecutiveColors(String sequence, int k) {
        int n=sequence.length();
        int ans=0,i=0,j=0,t=0,f=0;        
        while(i<n){
            char curr=sequence.charAt(i);
            if(curr=='R')t++;
            else f++;
            while(j<i && Math.min(t,f)>k){
                if(sequence.charAt(j)=='R')t--;
                else f--;
                j++;
            }
            ans=Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int k = sc.nextInt();
		System.out.println(new Solution().maxConsecutiveColors(str,k));
	
	}
}
/*
case =1
input=RWWR
1
output=3
case =2
input=RRRWWWWR
2
output=6
case =3
input=RWRWRWWRWRWRWRWRWRWRWRWRWRWRWRWRWRWRWRWRWRWRWWWWWWRRRWWWWWWWWRRRRRRRRWWWWWWRRRR
20
output=51
case =4
input=WWWWWWWWRWWWWW
1
output=14
case =5
input=WRWRWRWRWRWRWR
0
output=1
case =6
input=WWWWWWWWWWWWWWWWWWWW
5
output=20
*/