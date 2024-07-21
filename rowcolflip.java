
/*
 * There are some bulbs arranged in the form of grid on a wall,
Each bulb can emit either blue light or red light, where blue light 
indicates with 0 and red light indicates with 1.
You are given the initial arrangement of the bulbs.

You are allowed to perform the following toggle operation, 
- You can choose any row or column of bulbs 
- You can toggle each bulb color in that row or column 
(i.e., changing all blue to red[0's to 1's] and red to blue [ 1's to 0's]).

Your task is to return 'true' if it is possible to toggle all the bulbs in
the arrangement to emit blue light, by using any number of toggle operations 
or 'false' otherwise.

NOTE: It is a rectangular grid.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the grid
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
3 3
1 0 1
0 1 0
1 0 1

Sample Output-1:
----------------
true

Explanation: 
------------
Toggle the bulbs in column-1 and column-3
Now, The arrangement looks like
0,0,0
1,1,1
0,0,0

Now toggle the bulbs in row-2, So that all the bulbs emit blue color only.
0,0,0
0,0,0
0,0,0


Sample Input-2:
---------------
3 3
1 0 0
0 1 0
0 0 0

Sample Output-2:
----------------
false

 */
import java.util.*;

class rowcolflip {
    public static boolean help(int[][] a, int m, int n) {
        if (m <= 1)
            return true;
        for (int i = 1; i < m; i++) {
            if (!find(a[0], a[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(int[] a, int[] b) {
        boolean x = true, y = true;
        for (int i = 0; i < a.length; i++) {
            x = x && (a[i] == b[i]);
            y = y && (a[i] != b[i]);
        }
        return x || y;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(help(a, m, n));
    }
}