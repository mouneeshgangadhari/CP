/*
Input number of rows m and number of columns n.
Input m x n grid of integer values. 
We are required to find the Longest path in the given grid.
We can start from any of the cells, but the values in the path should be in increasing order.
Return the length of the path found.

From each cell, you can either move in four directions: left, right, up, or down. 
 

Example 1:
Input:
3	//Number of Rows
3	//Number of Columns
9 9 4
6 6 8
2 1 1
Output: 4
Explanation: The longest path is [1, 2, 6, 9].

Example 2:
Input: 
3
3
3 4 5
3 2 6
2 2 1
Output: 4
Explanation: The longest path is [3, 4, 5, 6] or [2, 4, 5, 6]. 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 20
0 <= grid[i][j] <= 100
*/


import java.util.*;
class LongestPath {
    public int longestPath(int[][] grid,int row, int col) 
	{
        if (row == 1 && col == 1)
            return 1;

        int max = 1;
        for (int i = 0; i < row; i++) 
            for (int j = 0; j < col; j++) 
                max = Math.max(max, bfs(grid, i, j));

        return max;
    }

    public int bfs(int[][] grid, int x, int y) 
	{
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) 
		{
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) 
			{
                int[] curPos = queue.poll();

                for (int[] dir : dirs) 
				{
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) 
                        continue;
              
                    if (grid[nextX][nextY] <= grid[curPos[0]][curPos[1]])
                        continue;
                    
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return ans;
    }
	public static void main(String args[] )
	{	
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                grid[i][j] = sc.nextInt();
        System.out.println(new LongestPath().longestPath(grid,m,n));
	} 
}


/*
Test Cases:
case=1
input=5
5
1 8 2 9 3
4 6 1 4 2
0 7 8 2 4
9 5 9 10 12
1 2 3 14 13
output=10

case=2
input=4
6
10 100 15 55 30 25
64 55 47 36 22 80
59 25 35 92 86 5
73 20 15 10 8 7
output=11

case=3
input=1
1
10
output=1

case=4
input=1
5
6 2 5 3 1
output=3

case=5
input=15
20
48 89 13 2  77 33 6  61 55 96 59 60 95 81 87 33 79 43 44 74
50 81 90 35 72 22 61 8  33 85 46 30 39 10 38 38 51 12 60 13
64 24 75 56 36 85 49 73 55 31 100 95 31 77 97 91 23 81 51 48
93 17 91 25 53 18 95 31 79 26 72 99 97 70 49 55 70 3  25 10
23 60 34 30 28 85 66 40 5  93 59 11 64 48 27 80 5  55 99 50
94 25 17 41 90 52 81 76 100 31 20 30 79 30 21 35 91 19 30 48
64 95 82 38 73 100 32 78 11 21 40 26 24 54 33 59 26 61 15 13
91 78 84 71 59 47 30 72 17 70 17 66 53 34 42 33 25 23 19 80
30 61 40 22 50 62 11 79 42 33 94 80 88 46 12 25 45 48 53 36
5  85 76 9  27 51 13 87 41 90 39 8  29 62 77 70 82 1  93 43
25 62 66 16 38 33 65 88 48 75 38 46 52 47 55 86 94 39 64 59
51 78 33 81 13 48 90 39 55 87 60 60 5  62 57 32 90 62 53 30
75 71 72 81 24 94 63 74 90 39 3  9  58 51 50 81 85 100 92 28
48 82 27 15 92 42 22 53 94 89 72 33 8  65 76 18 13 98 73 56
71 63 33 100 27 8  93 46 67 32 45 14 89 39 32 17 94 15 26 85
output=9

case=6
input=10
12
59 89 70 12 87 15 39 44 80 35 99 5
20 28 18 49 100 85 88 25 77 71 8 42
31 66 58 61 92 12 30 74 9  95 37 19
93 68 66 11 27 55 2  76 63 35 42 84
48 56 76 3  69 10 71 47 54 99 1  87
20 66 31 89 18 93 63 5  22 38 72 14
96 25 3  87 33 79 60 82 46 57 68 90
81 25 39 53 20 45 47 81 71 76 18 4
7  90 53 25 48 63 67 71 44 76 11 82
99 82 95 16 49 31 58 78 13 88 46 35
output=8

case=7
input=5
5
1 2 3 4 5
20 25 30 35 6
19 40 45 50 7
18 60 65 70 8
17 16 15 14 10
output=21

case=8
input=3
3
10 10 10
10 10 10
10 10 10
output=1
*/