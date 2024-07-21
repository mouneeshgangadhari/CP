/*
Given an N number of building heights, a 'move' consists of choosing any height and decreasing it by 1.

Your task is to make those building heights zigzag, ie.,

Every even-indexed height is greater than adjacent heights, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed height is greater than adjacent heights, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given heights into a zigzag heights.

Input format
------------
Line 1: an integer N
Next N lines, represents N heights of buildings

Output Format
--------------
An integer, minimum number of moves

Example 1:
----------
Input=
3
1
2
3
Output= 
2

Explanation: We can decrease 2 to 0 to form [1,0,3]  
or 3 to 1 to form [1,2,1]. Minimum moves is 2.

Example 2:
----------
Input=
5
9
6
1
6
2
Output=
4
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000

*/
import java.util.*;
class Solution {
    public int movesToMakeZigzag(int[] nums) {
		int n = nums.length, oddCost = 0, evenCost = 0; 
		for(int i = 0; i < nums.length; i++)
		{
			//if any of the neighbour is less than the curr index then reduce it
			if((i - 1 >= 0 && nums[i - 1] <= nums[i]) || (i + 1 < n && nums[i + 1] <= nums[i]))
			{  
				int min = Integer.MAX_VALUE; //find neigbour with minimum value

				if(i - 1 >= 0)
					min = Math.min(min, nums[i - 1]);
				if(i + 1 < n)
					min = Math.min(min, nums[i + 1]);

				int cost = nums[i] - min + 1; //calculate cost to make the value of current index lower than its neighbours

				//add cost to corresponding index cost variable
				if(i % 2 == 0)
					evenCost += cost;
				else
					oddCost += cost;
			}
		}
		return Math.min(oddCost, evenCost);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int i,n=sc.nextInt();
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println(new Solution().movesToMakeZigzag(arr));
	}
}  

/* Test cases

Case=1
Input=
3
1
2
3
Output= 
2

case=2
Input=
5
9
6
1
6
2
Output=
4

case=3
input=8
2
4
6
7
1
8
9
5
output=8

case=4
input=10
2
4
6
7
1
3
4
6
8
9
output=8

case=5
input=5
1
2
3
4
5
output=4
*/