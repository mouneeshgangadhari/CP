/*
Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color. Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the unique shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the unique shapes by the lights.

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
output =1

case =2
input =5 5
1 0 1 0 1
0 0 0 0 1
0 0 1 0 1
1 0 0 0 0
1 0 1 1 1
output =3

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
output =2

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
output =20

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
output =11

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
output =7

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
output =18


*/




import java.util.*;

class Solution 
{    
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    
    private class DisjointSet 
	{
        private int[] parent;
        private int[] size;
        
        public DisjointSet(int V) 
		{
            parent = new int[V];
            size = new int[V];
            for (int i=0; i<V; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
        
        public int find(int u) {
            return parent[u] == u ? u : (parent[u] = find(parent[u]));
        }
        
        public void union(int u, int v) 
		{
            int p1 = find(u);
            int p2 = find(v);
			// System.out.println("p1 " + p1 + " p2 " + p2 + " size p1 " + size[p1] + " size p2 " + size[p2]);
            if (p1 == p2) 
				return;

            if (size[p1] < size[p2]) 
			{
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
    
    public int numDistinctIslands(int[][] grid) 
	{
        int nr = grid.length;
        int nc = grid[0].length;
        DisjointSet ds = new DisjointSet(nr * nc);
        
        for (int i=0; i<nr; i++) 
		{
            for (int j=0; j<nc; j++) 
			{
                if (grid[i][j] == 1) 
				{
                    for (int k=0; k<4; k++) 
					{
                        int row = i + dRow[k];
                        int col = j + dCol[k];
						// System.out.println("i " + i + " j " + j + " k " + k + " row " + row + " col " + col);
                        if (row >= 0 && row < nr && col >= 0 && col < nc && grid[row][col] == 1) 
						{
                            ds.union(i*nc + j, row*nc + col);
                        }
                    }
                }
            }
        }

		System.out.println("disjoint set parent " + Arrays.toString(ds.parent));
		System.out.println("disjoint set size " + Arrays.toString(ds.size));

		String []pattern = new String[nr*nc];

		for(int i=0; i < nr*nc; i++)
			pattern[i]= "";
            
		for(int i=0;i < nr; i++)
		{
			for(int j=0; j<nc; j++)
			{
				if(grid[i][j]==0)
					continue;
					
				int parent = ds.find(i*nc+j);
				pattern[parent] += String.valueOf(i*nc + j-parent);
				System.out.println("i " + i + " j " + j + " parent " + parent + " pattern[parent] " + pattern[parent]);
			}
		}
            
		Set<String>tmp = new HashSet<>();
		for(int i=0;i<nr*nc; i++)
		{
			if(pattern[i].length()!=0)
			{
				System.out.println("i " + i + " pattern[i] " + pattern[i]);
				tmp.add(pattern[i]);
			}
		}
		return tmp.size();        
    }
}

public class DistinctIslands
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();
				
		System.out.println(new Solution().numDistinctIslands(grid));
	}
}
