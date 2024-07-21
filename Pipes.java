/*
Naveen manages pipe warehouse.There are n number of pipes placed vertically 
along a wall. Given l[i] is the length of the ith pipe placed on the wall from 
left to right(0-indexed). Naveen's task is to check if the pipes are in 
non-decreasing order of lengths on the wall from left to right.
If not,he can choose only 1 pipe on the wall and replace it with another pipe 
from warehouse to make it non-decreasing order.

There are all integer type of lengths are provided from warehouse.
Help Naveen whether he can can make the pipes in non-decreasing order.

Input Format:
-------------
Line-1: An integer n, number of pipes on the wall.
Line-2: n space separated integers represents length of each pipe.


Output Format:
--------------
return boolean value

Sample Input-1:
---------------
5
3 4 7 6 8

Sample Output-1:
----------------
true

Explanation:
------------
Replace 7 with 5 will become non decreasing array.

Sample Input-2:
---------------
4
2 5 4 1

Sample Output-2:
----------------
false

Explanation:
------------
Inorder to make it non-decreasing array we have to replace 2 elements which is not allowed.

*/
import java.util.*;
class Pipes
{
    public static boolean help(int[] a,int n){
        int c=0;
        for(int i=1;i<n;i++){
            if(a[i-1]>a[i]){
                c++;
            }
            if(c>1){
                return false;
            }
            
        }
        return true;
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(help(a,n));
    }
}


