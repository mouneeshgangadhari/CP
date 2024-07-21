/*
 * Mr.Ram is playing a map game, which will have n locations and routes from one location to another,
routes is a 2D integer array of length n -1, where routes[i]=[ai,bi] indicates that 
there is an undirected edge between locations ai and bi in the map. 
And one more array is given which consists of restricted locations. 
Ram has to visit maximum number of locations from location 0 without visiting a restricted location. 
Can you write a Program to solve this problem. 


Note that node 0 will not be a restricted node.

input format : an integer n
			   n-1 number of integer pairs
			   an integer m
			   m number of integers
u

Example 1:
Input=7
0 1
1 2
3 1
4 0
0 5
5 6
2
4 5
Output: 4
Explanation: .
We have that [0,1,2,3] are the only locations that can be reached from location 0 without visiting a restricted location.
Example 2:


Input= 7
0 1
0 2
0 5
0 4
3 2
6 5
3
4 2 1
Output: 3
Explanation: 
We have that [0,5,6] are the only locations that can be reached from location 0 without visiting a restricted location.
 

Constraints:

2 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.
1 <= restricted.length < n
1 <= restricted[i] < n
All the values of restricted are unique.

 */

import java.util.Scanner;

public class Reachable {
    public static int n;
    int[] p, r;

    public Reachable(int n) {
        this.n = n;
        p = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            r[i] = 0;
        }
    }

    public int find(int x) {
        if (p[x] == x)
            return x;
        return p[x] = find(p[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX > rootY)
            p[rootX] = rootY;
        else if (rootX < rootY)
            p[rootY] = rootX;

    }

    public boolean check(int x, int[] rest) {
        for (int a : rest) {
            if (x == a)
                return false;
        }
        return true;
    }

    public int getMaxLocations(int[][] routes, int[] rest) {
        int c = 0;
        for (int[] x : routes) {
            int u = x[0];
            int v = x[1];
            if (!check(u, rest) || !check(v, rest)) {
                continue;
            }
            union(u, v);
        }
        for (int x : p) {
            if (x == 0)
                c++;
        }
        // System.out.println(Arrays.toString(p));
        return c;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Reachable obj = new Reachable(n);
        int[][] routes = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            routes[i][0] = sc.nextInt();
            routes[i][1] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] rest = new int[m];
        for (int i = 0; i < m; i++) {
            rest[i] = sc.nextInt();
        }
        System.out.println(obj.getMaxLocations(routes, rest));

    }
}
