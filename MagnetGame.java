/*


Bablu is playing with Magnets and Iron balls.
Bablu has given a flat surface of m*n size, 
each position contains either empty '0', an Iron ball 'B' 
or Wooden Block 'W' (The wooden block is an anti-magnetic agent), 

Your task is to help Bablu to find the maximum number of 
Iron Balls he can attract by using a Magnet.

The Magnet attracts all the iron balls in the same row and column 
from their positions until the wooden block.
since the wooden block is an anti-magnetic block.

Note: You can only put the magnet in an empty position.

Input Format:
-------------
Line-1: Two integers m and n, size of the surface.
Next 'm' lines:  'n' space-separated characters only ('0', 'B', 'W').

Output Format
--------------
Print an integer, the maximum number of Iron Balls can be attracted by using a Magnet


Sample Input-1:
----------------
3 4
0 B 0 0 
B 0 W B
0 B 0 0

Sample Output:
--------------
3 

Explanation:
------------
For the given grid,
	0 B 0 0 
	B 0 W B
	0 B 0 0
Placing a Magnet at (1,1) attacts 3 iron balls. 
*/

import java.util.*;
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] g = new int[m][n];
        for (int i = 0; i < m; ++i) {
            int t = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'W') {
                    t = 0;
                } else if (grid[i][j] == 'B') {
                    ++t;
                }
                g[i][j] += t;
            }
            t = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 'W') {
                    t = 0;
                } else if (grid[i][j] == 'B') {
                    ++t;
                }
                g[i][j] += t;
            }
        }
        for (int j = 0; j < n; ++j) {
            int t = 0;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 'W') {
                    t = 0;
                } else if (grid[i][j] == 'B') {
                    ++t;
                }
                g[i][j] += t;
            }
            t = 0;
            for (int i = m - 1; i >= 0; --i) {
                if (grid[i][j] == 'W') {
                    t = 0;
                } else if (grid[i][j] == 'B') {
                    ++t;
                }
                g[i][j] += t;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, g[i][j]);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args){
	 Scanner sc = new Scanner(System.in);
	 int m = sc.nextInt();
	 int n = sc.nextInt();
	 char[][] ar = new char[m][n];
	 for(int i=0;i<m;i++)
		 for(int j=0;j<n;j++)
			ar[i][j] = sc.next().charAt(0);
	 
	 System.out.println(new Solution().maxKilledEnemies(ar));

	}
}
/*

=== testcases ===
case =1
input =3 4
0 B 0 0 
B 0 W B
0 B 0 0
output =3

case =2
input =5 6
0 0 0 B B B
B B 0 B 0 B
B 0 W B 0 0
B B B 0 0 B
0 0 0 B 0 0
output =8

case =3
input =5 6
0 0 B B B B
B B 0 B 0 B
B 0 W B B 0
B B B 0 W B
0 0 0 B B 0
output =7

case =4
input =6 7
0 0 0 0 B 0 B
0 B B B 0 B 0
B B 0 0 W 0 B
0 B B W B B W
0 W B 0 B W 0
0 B B B 0 B B
output =7

case =5
input =10 10
0 0 0 0 B B 0 0 0 B
0 0 0 0 0 B B 0 0 0
B 0 0 0 B 0 0 B B 0
0 B 0 0 0 B B B B B
B 0 0 B B B 0 B 0 B
0 B 0 B B B 0 B 0 B
0 0 B 0 0 0 0 0 B B
0 B B B 0 B B 0 0 0
0 B 0 B 0 B 0 0 0 B
0 B 0 B B B 0 0 0 0
output =12

case =6
input =10 10
0 0 0 0 B B 0 0 0 B
0 0 0 0 0 B B 0 0 0
B 0 0 0 B 0 W B B 0
0 B 0 0 0 B B B W B
B 0 0 B B B 0 B 0 B
0 B 0 B W B 0 B 0 W
0 0 B 0 0 0 0 0 B B
0 B W B 0 B B 0 0 0
0 B 0 B 0 W 0 0 0 B
0 B 0 B B B 0 0 0 0
output =11

case =7
input =10 10
B B B 0 0 B 0 B 0 B
0 0 0 B B 0 0 0 0 W
B 0 0 B B W 0 0 0 0
0 B 0 W 0 B B B B 0
B W B 0 0 0 B 0 B B
B 0 0 0 0 B W B B B
B 0 0 0 0 0 B B 0 B
0 0 B 0 0 W 0 0 0 B
0 B 0 B 0 0 0 B B 0
B 0 0 B B B 0 0 0 B
output =10

case =8
input =10 10
B B B W W B W B W B
W W W B B W W W W B
B W W B B B W W W W
W B W B 0 B B W B 0
B B B W W W B W B B
B W 0 W W B B B B B
B W W W W W B B W B
W W B W W W W W W B
W B 0 B W 0 W B B W
B W W B B B W W W B
output =5


*/