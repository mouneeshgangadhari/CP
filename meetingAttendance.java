/*
There is a crowd attended for a political meeting with different groups and each
group had unique colored dresses wearing. We asked n people in the crowd that
"How many are attended from your group excluding yourself?" and collected the 
answers in an integer array answers where group[i] is the answer of the ith group.

Given the array groups, return the minimum possible attendance that could be 
there in the meeting.

Constraints:
------------
    1 <= n <= 1000
    0 <= group[i] < 1000

Input Format:
-------------
Line-1: An integer n, represents the people answered.
Line-2: n space seperated integers represents the answers.

Output Format:
--------------
return an integer represents minimum possible attendance.

Sample Input-1:
---------------
5
1 2 1 2 1

Sample Output-1:
----------------
7

Explanation:
------------
Out of the three groups that answered "1", there could be two groups wearing to 
the same color, say white and the other group wearing some other color, say 'pink'
The two groups that answered "2" could both be wearing the same color, say 'yellow'.
The minimum possible number of attendance in the meeting is 7.

    
Sample Input-2:
---------------
5
3 2 1 6 4

Sample Output-2:
----------------
21

*/

import java.util.*;
class Solution {
	public int minAttendance(int[] answers) {
        Map<Integer,Integer> ansMap = new HashMap<>();
        int attended=0;
        for(int ans:answers){
            Integer count = ansMap.getOrDefault(ans,0);
            if(count>ans){
                attended+=count;
                count=0;
            }
            ansMap.put(ans,count+1);
        }
        for(Integer ans:ansMap.keySet()){
            attended+=(ans+1);
        }
        return attended;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(new Solution().minAttendance(arr));
	}
}

/*
==== testcases ====
case =1
input=5
3 2 1 6 4
output=21

case =2
input=5
1 2 1 2 1
output=7

case =3
input =20
4 9 10 9 1 10 7 4 3 5 2 7 7 6 9 6 5 4 2 2
output =56

case =4
input =50
9 4 12 13 3 6 2 17 14 4 12 10 20 5 11 20 6 11 14 13 12 20 6 13 2 8 5 1 1 12 6 7 16 2 10 19 8 17 18 16 16 20 10 11 5 17 20 11 10 9
output =214

*/
