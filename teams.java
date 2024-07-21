/*
There are n soldiers standing in a line. Each soldier is assigned a unique 
rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or 
(rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. 
(soldiers can be part of multiple teams).

Example 1:
Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. 
(2,3,4), (5,4,1), (5,3,1). 

Example 2:
Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.

Example 3:
Input: rating = [1,2,3,4]
Output: 4
 
Constraints:
n == rating.length
3 <= n <= 1000
1 <= rating[i] <= 105
All the integers in rating are unique.
*/
import java.util.*;
class teams{
    public static int help(int[] a,int n){
        int c=0;
        for(int i=0;i<n;i++){
            int ls=0,lg=0,rs=0,rg=0;
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]){
                    rs++;
                }
                else if(a[i]<a[j]){
                    rg++;
                }
            }
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    ls++;
                }
                else if(a[i]<a[j]){
                    lg++;
                }
            }
            c=c+(ls*rg+rs*lg);
            
        }
        return c;
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

