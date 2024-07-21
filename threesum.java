/*Mr. Varun is an accountant in a shop,daily turnover of shop is in lakhs, some times it 
is negetive also when purchses by the shop are more than sales of shop.
One day shop owner called Varun and asked him to give the sum of three days turnover which is near to given target.
Help Varun with a your program skills.



input format : integer (n)
               n number of integers
			   integer (target)
output format : integer

You may assume that each input would have exactly one solution.

Example 1:

Input:4
-1 2 1 -4
1
Output: 2

Example 2:
Input:3
0 0 0 
1
Output: 0
*/

import java.util.*;
class threesum
{
    public void findNearTarget(int[]arr,int t)
    {
        int n = arr.length;
        int min=Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n-2;i++)
        {
            int w = arr[i];
            int l=i+1,r=n-1;
            while(l<r)
            {
                int s = w+arr[l]+arr[r];
                if(Math.abs(s-t)<min){
                    ans=s;
                    min = Math.abs(s-t);
                }
                if(s<=t) l++;
                else r--;
            }
        }
        System.out.println(ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int t = sc.nextInt();
        Arrays.sort(arr);
        new threesum().findNearTarget(arr,t);
    }
}