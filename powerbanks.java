/*
 * You have n Devices.
Input an integer n and an array B where the ith power bank can run a device for
B[i] minutes.
All n Devices should run simultaneously using the given power banks.

Initially, you can connect at most one power bank to each device. 
After that and at any time, you can cahge the power bank of a device any 
number of times.
The connected power bank can be a totally new power bank or a power bank 
from another device.
You may assume that the removing and inserting processes take no time.

Return the maximum number of minutes you can run all the n Devices simultaneously.


Example 1:
----------
Input: 2 //Number of Devices (n)
3 3 3 //Array of power banks(B)
Output: 4

Explanation: 
Initially, insert power bank 0 into the first device and power bank 1 into 
the second device.
After two minutes, remove power bank 1 from the second device and insert 
power bank 2 instead. Note that power bank 1 can still run for one minute.
At the end of the third minute, power bank 0 is drained, and you need to remove 
it from the first device and insert power bank 1 instead.
By the end of the fourth minute, power bank 1 is also drained, 
and the first device is no longer running.
We can run the two Devices simultaneously for at most 4 minutes, so we return 4.

Example 2:
----------
Input: 2
1 1 1 1
Output: 2

Explanation: 
Initially, insert power bank 0 into the first device and power bank 2 into the 
second device. 
After one minute, power bank 0 and power bank 2 are drained so you need 
to remove them and insert power bank 1 into the first device and power bank 3 
into the second device. 
After another minute, power bank 1 and power bank 3 are also drained so 
the first and second Devices are no longer running.
We can run the two Devices simultaneously for at most 2 minutes, so we return 2.
 
Constraints:
1 <= n <= powerBanks.length <= 105
1 <= powerBanks[i] <= 109

USE THE GIVEN JAVA CODE SEGMENT TO SOLVE ABOVE PROBLEM

import java.util.*;
class Solution 
{
    public long maxRunTime(int n, int[] powerBanks) 
	{
        //WRITE YOUR CODE HERE
    }
	public static void main(String args[] )
	{	
		Scanner sc=new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
        String[] powerBanks = sc.nextLine().split(" ");
		int B[]=new int[powerBanks.length];
		int i = 0;
        for (String x : powerBanks)
		{
            B[i]=Integer.parseInt(x);
			i=i+1;
		}
        
        System.out.println(new Solution().maxRunTime(n,B));
	}  
}

 */

import java.util.Scanner;

public class powerbanks {
    public long maxRunTime(int n, int[] powerBanks) {
        long sum = 0;
        for (int b : powerBanks) {
            sum += b;
        }
        
        long low = 1;
        long high = sum / n;
        
        while (low < high) {
            long mid = high - (high - low) / 2;
            if (canRunForMinutes(powerBanks, n, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private boolean canRunForMinutes(int[] powerBanks, int n, long minutes) {
        long totalAvailable = 0;
        for (int b : powerBanks) {
            totalAvailable += Math.min(b, minutes);
        }
        return totalAvailable >= n * minutes;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] powerBanks = sc.nextLine().split(" ");
        int B[] = new int[powerBanks.length];
        int i = 0;
        for (String x : powerBanks) {
            B[i] = Integer.parseInt(x);
            i = i + 1;
        }

        System.out.println(new powerbanks().maxRunTime(n, B));
    }
}
