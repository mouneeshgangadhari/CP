/*
Input 'n', an array of length ‘n’ and a number ‘k’. 
Find the maximum sum of ‘k’ consecutive elements inside the array.

Sample Test Cases:

Test Case-1
input=4
2 3 4 5
2
output=9

Test Case-2
input=9
1 4 2 10 2 3 1 0 20
4
output=24

*/
import java.util.*;
class SlideWindow
{
    public static int help(int[] a,int n,int k){
        int max=0;
        for(int i=0;i<k;i++){
            max=max+a[i];
        }
        int res=max;
        for(int i=k;i<n;i++){
            res=res+a[i]-a[i-k];
            max=Math.max(max,res);
        }
        return max;
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            
        }
        int k=sc.nextInt();
        System.out.println(help(a,n,k));
    }
}