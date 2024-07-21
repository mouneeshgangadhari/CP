/*
Master sathya is doing his mathematics home work, in that one problem statement is as follows,
there are list of non-decreasing temperatures values (only integers) are given he need to find the squares of each temperature and return that list in non-decreasing order. Can you help him with a program.

input format: an integer (n)
              n number of integers in sorted order
output format: List of n integers in sorted order

Example 1:

Input:5
-4 -1 0 3 10
Output: [0, 1, 9, 16, 100]

Example 2:
input=8
1 2 3 4 5 6 7 8
output =[1, 4, 9, 16, 25, 36, 49, 64]


*/

import java.util.*;
class squaresortarr
{
    public void sqArr(int[] arr)
    {
        int n = arr.length;
        int[] res = new int[n];
        int idx=n-1;
        int l=0,r=n-1;
        while(l<=r)
        {
            int add = Math.max(Math.abs(arr[l]),Math.abs(arr[r]));
            res[idx--] = add*add;
            if(Math.abs(arr[l])<Math.abs(arr[r]))
            {
                r--;
            }
            else l++;
        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        new squaresortarr().sqArr(arr);
    }
}