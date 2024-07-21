/*
 * Mr.Miryam is very hungry he went to a new restaurant Avakaya Biryani. 
The restaurant was designed in such a way that 
the tables are arranged in a PXQ arrangement.

The PXQ arrangement is a character grid, contains 4 types of characters, 
each character indicated as follows.

'*' is Miryam location, there is exactly one '*'.
'#' is a Miryam's table with food. There may be multiple options.
'O' is an empty space, where we can walk through the way.
'X' is an hurdle unit, we cannot walk through these units.

The minimal path is decided such way Miryam can walk to any adjacent cell 
vertically or horizontally.

Your task is to help Mr.Miryam to find the smallest path to reach the food table.
If no path to reach table return -1.

Input Format:
-------------
Line-1: Two integers P and Q, Size of the grid.
Next P lines: Q space separated characters, from this set -> [ *, #, O, X ] 

Output Format:
--------------
Print an integer, Length of the shortest path.


Sample Input-1:
---------------
4 6
X X X X X X
X * O O O X
X O O # O X
X X X X X X

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 8
X X X X X X X X
X * O X O # O X
X O O X O O X X
X O O O O # O X
X X X X X X X X

Sample Output-2:
----------------
6

 */

import java.util.Scanner;

public class Restaurant {
    char[][] a;
    boolean[][] vis;
    int min;

    public Restaurant(int m, int n) {
        a = new char[m][n];
        vis = new boolean[m][n];
        min = Integer.MAX_VALUE;

    }

    public void dfs(int x, int y, char[][] a, int dis, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || a[x][y] == 'X') {
            return;
        }
        if (a[x][y] == '#') {
            min = Math.min(dis, min);
            return;
        }
        vis[x][y] = true;
        dfs(x + 1, y, a, dis + 1, m, n);
        dfs(x - 1, y, a, dis + 1, m, n);
        dfs(x, y + 1, a, dis + 1, m, n);
        dfs(x, y - 1, a, dis + 1, m, n);
        vis[x][y] = false;
    }

    public int help(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '*') {
                    dfs(i, j, a, 0, m, n);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Restaurant obj = new Restaurant(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obj.a[i][j] = sc.next().charAt(0);
                obj.vis[i][j] = false;
            }
        }
        System.out.println(obj.help(m, n));
        // System.out.println(Arrays.deepToString(obj.a));
    }
}
