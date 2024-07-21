/*Given a m * n matrix of ones and zeros, return how many square submatrices 
have all ones.

Example 1:
Input: matrix =
0 1 1 1
1 1 1 1
0 1 1 1
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:
Input: matrix = 
1 0 1
1 1 0
1 1 0
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 
Constraints:
1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/
import java.util.*;
class numberofsquares
{
    public static int help(int m,int n,int[][] a){
        int[][] dp=new int[m][n];
        int c=0;
        for(int i=0;i<m;i++){
            c=c+a[i][0];
            dp[i][0]=a[i][0];
        }
        for(int i=1;i<n;i++){
            c=c+a[0][i];
            dp[0][i]=a[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    c=c+dp[i][j];
                }
            }
        }
        return c;
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(help(m,n,a));
    }
}
