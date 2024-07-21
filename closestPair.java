/*
 * Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1

---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13

 */

import java.util.Scanner;

public class closestPair {
    static int[] res;
    public static void help(int[] a,int n,int[] b,int m,int k){
        int min=Integer.MAX_VALUE;
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(Math.abs(a[i]+b[j]-k)<min){
                res[0]=a[i];
                res[1]=b[j];
                min=Math.abs(a[i]+b[j]-k);
            }
            if(a[i]+b[j]<k){
                i++;
            }
            else{
                j--;
            }
        }
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int[] b=new int[m];
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        res=new int[2];
        help(a,n,b,m,k);
        System.out.println(res[0]+","+res[1]);
    }
}
