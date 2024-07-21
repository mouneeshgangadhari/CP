/*
 * Mr. Rathan, a developer at Google Maps, is working on a problem involving a set of locations and edges 
that connect these locations. Given a source location and a destination location,
he needs to determine whether there exists a route from the source to the destination.
 If a route exists, he should return true, otherwise, he should return false.

Note : edges are bidirectional.

Input format : two integers,one is number of locations(n) and second integer is	number of edges(e)
			   next e number of lines contains pair of integers which are edges
			   next line contains two integers source and destination
output format: true or false.

Example 1:
Input=3
3
0 1
1 2
2 0
0 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:
Input= 6
5
0 1
0 2
3 5
5 4
4 3
0 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
 */

import java.util.Scanner;

public class Route {
    int[] p, r;

    Test(int n){
        p=new int[n];
        r=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
            r[i]=0;
        }
    }

    public int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    public void union(int x, int y) {
        int x_par = find(x), y_par = find(y);
        if (x_par == y_par) {
            return;
        }
        if (r[x_par] > r[y_par]) {
            p[y_par] = x_par;
        } else {
            p[x_par] = y_par;
        }
    }

    public boolean help(int[][] a, int x, int y) {
        for (int[] arr : a) {
            int u = arr[0];
            int v = arr[1];
            if (find(u) != find(v)) {
                union(u, v);
            }
        }
        return find(x) == find(y);
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edges = sc.nextInt();
        Test obj = new Test(n);
        int[][] a = new int[edges][2];
        for (int i = 0; i < edges; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(obj.help(a, x, y));
    }
}
