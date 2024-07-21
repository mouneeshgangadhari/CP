/*
Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color. Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the number of shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the number of shapes by the lights.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by Blue Lights.


Sample Input-1:
---------------
4 5
1 1 0 1 1
1 1 0 0 1
0 0 0 0 0
1 1 0 0 0

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  		  1 1
1      and      1


=== testcases ===
case =1
input =4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1
output =2

case =2
input =5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1
output =4

case =3
input =8 8
1 1 0 1 1 0 1 1
1 1 1 1 1 1 1 0
0 1 0 1 0 1 1 1
1 1 1 0 0 1 0 1
1 1 0 0 1 1 1 0
0 1 1 1 1 1 0 1
1 1 1 0 1 0 0 0
1 0 1 1 0 1 0 0
output =3

case =4
input =18 18
1 1 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0
1 0 1 1 1 0 0 1 0 1 0 1 1 0 0 1 0 1
0 1 0 1 1 1 1 0 0 1 0 1 1 0 1 1 0 0
0 1 1 1 0 1 0 1 0 1 0 1 1 0 0 0 1 0
0 1 1 0 1 0 1 0 1 1 0 1 1 1 1 1 0 0
0 0 1 1 0 0 1 0 1 1 1 0 0 0 0 0 1 1
0 0 1 0 1 1 1 0 1 0 0 0 0 0 1 1 0 1
0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 0 0 1
0 0 0 0 1 1 1 0 1 1 1 0 1 1 1 0 0 0
0 1 1 1 1 1 0 0 1 1 0 0 1 1 1 0 1 0
1 0 0 0 0 1 0 0 1 0 0 1 0 0 0 0 0 1
1 1 1 1 1 0 0 1 0 0 1 0 0 0 0 1 1 1
1 1 1 1 1 0 0 1 1 1 0 0 1 1 1 0 0 1
1 0 0 0 1 0 0 1 1 1 0 0 1 1 1 1 0 0
0 0 1 0 1 0 1 0 1 1 0 0 1 1 0 0 0 1
0 1 1 0 1 0 1 0 0 0 0 1 0 1 0 0 1 0
0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1
0 1 0 0 0 1 1 1 0 0 1 1 1 0 1 0 1 0
output =35

case =5
input =12 12
1 1 0 0 1 1 1 1 0 1 0 1
1 0 0 1 1 0 1 0 0 1 0 1
0 0 0 0 0 1 0 1 1 0 1 0
0 1 0 1 0 1 0 0 0 1 0 1
1 1 0 0 1 1 1 0 0 0 1 1
1 0 1 1 1 1 0 1 1 1 0 0
1 1 0 0 1 0 1 0 1 0 1 0
1 0 1 0 0 1 0 1 0 0 0 1
0 0 1 0 0 1 1 0 1 1 1 1
1 1 0 1 0 1 0 0 1 0 1 0
0 0 1 0 1 0 1 0 1 1 1 1
1 1 0 1 1 0 0 1 1 0 1 0
output =24

case =6
input =15 12
0 0 0 0 0 1 0 0 1 1 0 0
0 1 1 0 1 1 1 0 0 1 1 0
0 1 1 1 1 0 0 0 1 1 0 0
0 0 0 1 1 0 0 0 0 0 0 1
0 0 1 0 0 1 0 0 0 1 0 0
1 0 1 0 1 1 1 0 1 1 0 1
0 1 1 0 1 0 0 0 0 0 0 0
1 1 1 0 1 1 0 0 0 0 1 0
0 0 1 1 1 1 0 1 0 1 1 1
0 0 1 1 1 0 1 0 0 0 1 0
1 0 1 0 1 1 1 0 0 1 1 0
1 0 1 1 1 1 0 1 1 1 1 1
1 1 1 1 0 0 0 0 0 1 0 0
0 1 0 1 1 1 0 0 0 1 0 1
1 1 1 1 0 0 1 1 1 0 0 0
output =11

case =7
input =7 12
1 1 0 0 0 1 1 1 0 0 0 1
1 1 0 1 0 1 1 1 1 1 0 1
1 1 1 0 0 0 1 1 0 1 0 1
1 0 0 1 1 0 1 1 0 0 0 0
1 1 1 1 1 0 0 0 1 1 1 0
0 1 0 0 1 0 1 0 1 1 0 0
0 1 0 0 1 0 1 0 1 1 0 0
output =6

case =8
input =20 19
0 0 1 1 1 0 1 0 0 1 1 1 1 0 0 0 1 0 0
0 0 0 0 1 0 0 0 0 1 1 1 0 0 1 0 1 1 0
1 0 0 1 0 1 0 0 1 1 1 1 1 1 0 0 1 0 0
1 0 1 1 1 0 0 1 1 0 1 0 1 0 0 0 0 0 1
1 1 0 1 1 1 1 1 0 0 0 1 0 1 0 1 1 0 1
0 0 1 0 1 1 0 1 0 1 1 0 0 0 1 0 1 0 1
1 0 0 0 1 0 0 0 1 0 1 0 0 1 1 0 0 1 1
0 0 0 1 1 1 0 0 0 0 0 1 1 0 0 0 1 1 1
0 0 1 1 0 0 1 0 0 1 1 0 0 1 0 1 0 1 1
1 1 1 0 0 1 0 0 1 1 0 0 0 1 0 1 1 0 1
1 1 1 1 0 1 1 0 1 0 1 0 1 0 0 1 0 0 1
1 1 1 0 1 0 0 1 0 0 0 1 0 0 1 0 1 1 0
1 0 1 1 0 0 0 1 0 0 1 0 0 0 1 0 0 1 1
0 0 1 0 1 0 1 0 1 1 0 0 0 0 1 1 0 1 1
0 1 0 0 0 1 1 0 0 0 0 1 1 1 1 1 1 0 0
0 0 0 0 1 0 0 0 1 1 1 0 0 1 1 1 1 1 0
1 1 1 0 1 1 0 1 0 1 0 1 0 0 1 1 1 1 1
0 1 0 0 0 0 1 1 1 0 0 1 1 1 0 1 1 1 0
0 0 0 1 1 1 1 1 1 1 1 0 1 1 0 0 1 0 1
1 1 1 0 0 1 0 0 1 1 0 0 0 1 0 1 1 0 1
output =41

*/

/*
The idea is to consider all 1 values as individual sets. 
Traverse the matrix and do a union of all adjacent 1 vertices. 
*/

import java.util.*;
public class NumOfIslands 
{
	private int[] sz;
	private int[] parent;
	private int rows, cols;
	public int find(int p) 
	{
		while (parent[p] != p) 
			p = parent[p];
		return p;
	}

	public void union(int p, int q) 
	{
		System.out.println("union p " + p + " q " + q);
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		
		if (sz[rootP] < sz[rootQ])	
		{
			sz[rootQ] += sz[rootP]; 
			parent[rootP] = parent[rootQ];
		}
		else
		{
			sz[rootP] += sz[rootQ]; 
			parent[rootQ] = parent[rootP];
		}
	}

	private boolean inside(int x, int y) 
	{
		return (x >= 0 && y >= 0 && x < rows && y < cols);
	}

	public int numIslands(int[][] grid) 
	{
		if (grid == null || grid.length ==0) 
			return 0;

		rows = grid.length;
		cols = grid[0].length;
		sz = new int[rows * cols];
		parent = new int[rows * cols];
		for (int i = 0; i < rows * cols; i++) 
		{
			parent[i] = i;
			sz[i] = 1;
		}

		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				if (grid[i][j] == 1) 
				{
					int tmp = i*cols + j;
					System.out.println("tmp " + tmp);
					if (inside(i-1, j) && grid[i-1][j] == 1) 
						union(tmp, tmp - cols);
					if (inside(i, j-1) && grid[i][j-1] == 1) 
						union(tmp, tmp - 1);
					if (inside(i+1, j) && grid[i+1][j] == 1) 
						union(tmp, tmp + cols);
					if (inside(i, j+1) && grid[i][j+1] == 1) 
						union(tmp, tmp + 1);
				}
			}
		}
		int islands = 0, i = 0;
		
		while (i < rows * cols) 
		{
			System.out.println("i " + i + " parent[i] " + parent[i]);
			if (i == parent[i] && grid[i/cols][i%cols] == 1) 
				islands++;
			i++;
		}
		return islands;
	}

	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int row=s.nextInt();
		int col=s.nextInt();	
		int arr[][]=new int[row][col];
		for (int i=0;i<row ;i++ )
		{
			for (int j=0;j<col ;j++ )
			{
				arr[i][j]=s.nextInt();
			}
		}
		System.out.println(new NumOfIslands().numIslands(arr));
	}
}
