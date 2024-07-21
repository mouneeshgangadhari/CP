/*
You are given an 'm * n' matrix 'spaces' that represents the layout of an art gallery. 
If a space is unavailable, it is denoted by a '#' character; 
otherwise, it is denoted by a '.' character.

Art pieces can be influenced by those placed to the left, right, upper left, 
and upper right due to their proximity, but they are not influenced by pieces 
directly in front or behind them. 
Return the maximum number of art pieces that can be placed in the gallery 
without any influence being possible.

Art pieces must be placed in available spaces.

Input format
------------
Number of rows in the space matrix 
Space matrix

Output format
-------------
Integer which represents the result

Example 1:
Sample Input 1
--------------
3
#.##.#
.####.
#.##.#

Sample Output 1
---------------
4

Explanation: The curator can place 4 art pieces in available spaces so they don't influence each other.


Example 2:
Sample Input 2
--------------
5
.#
##
#.
##
.#

Sample Output 2
---------------
3


Constraints:

- 'spaces' contains only characters '.' and '#'.
- 'm == spaces.length'
- 'n == spaces[i].length'
- '1 <= m <= 8'
- '1 <= n <= 8'

*/
import java.util.*;

class Solution {
    private int m, n;
    private int[][] g;
    private int[][] dir = {{0, -1}, {-1, -1}, {1, -1}, {0, 1}, {-1, 1}, {1, 1}};
    private int S, T;
    private int flow;

    int maxPieces(char[][] spaces) {
        m = spaces.length;
        n = spaces[0].length;
        S = m * n;
        T = m * n + 1;
        g = new int[m * n + 2][m * n + 2]; // residual capacity
        int spacecnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (spaces[i][j] == '#') continue;
                spacecnt++;
                if (j % 2 == 0) {
                    g[S][i * n + j] = 1;
                    for (int d = 0; d < 6; ++d) {
                        int ni = i + dir[d][0];
                        int nj = j + dir[d][1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n || spaces[ni][nj] == '#') continue;
                        g[i * n + j][ni * n + nj] = 1;
                    }
                } else {
                    g[i * n + j][T] = 1;
                }
            }
        }
        flow = 0;
        EK();
        return spacecnt - flow;
    }

    void EK() {
        while (true) {
            int[] pre = new int[m * n + 2];
            Arrays.fill(pre, -1);
            bfs(pre);
            if (pre[T] == -1) break;
            int v = T;
            while (v != S) {
                int u = pre[v];
                g[u][v]--;
                g[v][u]++;
                v = u;
            }
            flow++;
        }
    }

    void bfs(int[] pre) {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        boolean[] visited = new boolean[m * n + 2];
        visited[S] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < m * n + 2; ++i) {
                if (!visited[i] && g[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                    pre[i] = cur;
                }
            }
        }
    }
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.next());
		char[][] spaces=new char[n][];
		for(int i=0;i<n;i++)
			spaces[i]=sc.next().toCharArray();
        System.out.println(new Solution().maxPieces(spaces));

	}}

/* test cases
case=1
input=3
#.##.#
.####.
#.##.#
output=4

case=2
input=5
.#
##
#.
##
.#
output=3

case=3
input=5
#...#
.#.#.
..#..
.#.#.
#...#
output=
10

case=4
input=4
#..#..
##.##.
.###.#
#..##.

output=7
*/