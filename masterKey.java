/*


You are given a row of N rooms, all initially locked. You have a master key that you can use to unlock exactly one room. Inside each room, you will find a key to another room.

You need to follow these steps:
	Use the master key to unlock any one room of your choice.
	Use the key found in the unlocked room to unlock the next room.
	Repeat the process until you encounter a key to a room that is already unlocked, at which point you must stop.
You are given an array keys[] of length N, where the value at the i-th index represents the room number that the key in the i-th room unlocks. The values in keys[] are in the range [0..N-1] and are unique (no duplicates).

Your task is to determine the maximum number of rooms that can be unlocked starting from any room.
Input Format:
-------------
Line-1: An integer N, number of rooms.
Line-2: N space separated integers, keys of rooms.

Output Format:
--------------
Print an integer result.
 
Sample Input-1:
---------------
8
7 4 6 2 1 0 3 5

Sample Output-1:
----------------
3

Explanation:
-----------
keys[0] = 7, keys[1] = 4, keys[2] = 6, keys[3] = 2, keys[4] = 1, keys[5] = 0, 
keys[6] = 3, keys[7]=5.

You can start with Room-0 using the master key, you can open the following rooms:
  key[0]=7 =>  key[7]=5  =>  key[5]=0
          or
  key[2]=6 =>  key[6]=3  =>  key[3]=2

You can unlock maximum 3 rooms.

Sample Input-2:
---------------
 6
 3 2 4 0 5 1

 Sample Output-2:
 ----------------
 4
 
Sample Input-3:
---------------
5
0 1 2 3 4

 Sample Output-3:
----------------
1
*/
import java.util.*;
class Solution {
    Integer[]dp;
    public int unlockRooms(int[] nums) {
        dp=new Integer[nums.length];
        int ans=0;
        for(int i=0; i<nums.length; i++){
            ans=Math.max(ans,dfs(nums,i,new HashSet<>()));
        }
        return ans;
    }
    public int dfs(int[]nums,int si,HashSet<Integer> set){  
        if(set.contains(si)) 
			return 0;    
        if(nums[si]==si) 
			return 1;
        if(dp[si]!=null) 
			return dp[si];        
        set.add(si);
        dp[si] = 1 + dfs(nums,nums[si],set);
        return dp[si];
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println(new Solution().unlockRooms(ar));
	}
}
/*



=== testcases ===
case =1
input =5
0 1 2 3 4
output =1

case =2
input =6
3 2 4 0 5 1
output =4

case =3
input =8
7 4 6 2 1 0 3 5
output =3

case =4
input =15
4 9 8 2 7 10 13 14 12 3 6 5 0 11 1
output =10

case =5
input =15
14 12 3 6 5 0 11 1 4 9 8 2 7 10 13
output =7

case =6
input =20
19 17 15 13 11 9 7 5 3 1 2 4 6 8 10 12 14 16 18 0
output =12

case =7
input =20
9 7 5 1 2 4 6 19 17 15 3 12 14 16 18 0 13 11 8 10
output =6

case =8
input =30
9 26 7 5 1 21 2 4 6 23 20 19 17 25 15 3 12 28 14 29 16 22 18 27 0 24 13 11 8 10
output =23

case =9
input =30
27 0 24 13 11 8 10 9 26 7 5 1 21 2 4 6 23 28 14 29 16 22 18 20 19 17 25 15 3 12
output =25

case =10
input =40
9 26 7 30 5 1 31 21 2 3 12 28 36 37 14 29 16 38 22 18 27 39 0 24 13 11 8 10 32 4 6 23 20 33 19 17 25 34 15 35
output =14

*/
