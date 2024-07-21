/*

You are a telecom engineer working in airtel, you are receiving complaints about weak signal, now you want to make analysis on this. Then you made a n x n grid of all cell phone towers, where each grid consists of 0(presence of a tower) and 1( plane land -absence of a tower).Find a tower cell such that its distance to the nearest 1 cell is maximized, and return the distance. If no tower or plane exists in the grid, return -1.

the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 Example 1:
Input=3
1 0 1
0 0 0
1 0 1
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:
Input=3
1 0 0
0 0 0
0 0 0
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/
import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        int towerCells = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) q.offer(new int[]{i, j, 0});
                else towerCells++;
            }
        }
        if (q.isEmpty() || towerCells == 0) return -1;
        return bfs(grid, q, rows, cols);
    }
    private int bfs(int[][] grid, Queue<int[]> q, int rows, int cols) {
        int maxDist = 0;
        int[][] directions = {{1, 0, 1}, {-1, 0, 1}, {0, 1, 1}, {0, -1, 1}};
        while (!q.isEmpty()) {
            int numCells = q.size();
            for (int n = 0; n < numCells; n++) {
                int[] cell = q.poll();
                maxDist = Math.max(maxDist, cell[2]);
                for (int[] dir : directions) {
                    int i = cell[0] + dir[0];
                    int j = cell[1] + dir[1];
                    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 1) continue;
                    grid[i][j] = 1;
                    q.offer(new int[]{i, j, cell[2] + 1});
                }
            }
        }
        return maxDist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][]ar = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				ar[i][j]=sc.nextInt();
		Solution sol = new Solution();
        System.out.println(sol.maxDistance(ar)); 
    }
}
/*
case =1
input=4
1 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
output=6
case =2
input=4
1 1 1 1
1 1 1 1
1 1 1 1
1 0 1 1
output=1
case =3
input=5
1 1 1 1 1
1 0 0 0 1
1 0 1 0 1
1 0 1 0 1
1 1 1 1 1
output=1
case =4
input=5
1 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
output=8
case =5
input=5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
output=-1
case =6
input=5
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
output=1*/