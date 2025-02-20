/*
Hulk and Thor become best friends now. 
Hulk lives in the P-th house while Thor lives in the N-th house. 
Hulk has decided to meet Thor every day. After going for many days, 
he notices that there are few streets such that he passes every time 
he goes to meet Thor, no matter which path he takes.

You have been given a grid of N houses in the form of undirected graph. 
Houses are numbered from 1 to N.
For each I-th query, you have been given P (Hulk's house). 
You have to say how many streets are there which he encounters in every path 
he takes to go from P to N. If there is no such street, print "-1".
Also, note P can be equal to N.

Input Format:
-------------
Line-1: Two space separated integers N and M, Number of houses, number of streets.
Next M lines: contain two space-separated integers u and v, 
		denoting a street between house-u and house-v.
Next line: contains an integer P.

Output Format:
--------------
Print an integer, number of streets in that path.


Sample Input-1:
---------------
4 3
1 2
1 3
2 4
1

Sample Output-1:
----------------
2

Explanation:
------------
There is only one path 1->2->4. so answer = 2


Sample Input-2:
---------------
4 3
1 2
1 3
2 4
4

Sample Output-2:
----------------
-1

Explanation:
------------
There is no path as they both live in the same house 4.
So answer = -1.

*/

import java.io.*;
import java.util.*;
 
public class FindLocation{

    static List<Integer>[] g;
    static int[] parent, disc, low, ans;
    static boolean[] vis;
    static int n, m;
    
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
            n = in.nextInt();
            m = in.nextInt();
			g = new ArrayList[n+1];
			parent = new int[n+1];
			disc = new int[n+1];
			low = new int[n+1];
			ans = new int[n+1];
            vis = new boolean[n+1];
			for(int i = 1 ; i <= n; i++) {
                g[i] = new ArrayList<>();
                parent[i] = -1;
                ans[i] = 0;
                vis[i] = false;
            }
            
            
            for(int i = 1; i <= m; i++) {
                int u = in.nextInt(), v = in.nextInt();
                g[u].add(v);
                g[v].add(u);
            }
            
            dfs(n, 0);
 
            for(int i = 1 ; i <= n; i++) {
                vis[i] = false;
            }
 
            dfs2(n);

			int x = in.nextInt();
			System.out.println((ans[x] == 0) ? "-1" : ans[x]);
    }
 
    static void dfs(int u, int time) {
        vis[u] = true;
        disc[u] = low[u] = ++time;
 
        for(int v : g[u]) {
            if(!vis[v]) {
                parent[v] = u;
                dfs(v, time);
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > disc[u]) {
                    ans[v] = 1;                    
                }
 
            }
            else if(parent[u] != v) {
                low[u] = Math.min(disc[v], low[u]);
            }
        }
    }
 
    static void dfs2(int u) {
        vis[u] = true;;
        for(int v : g[u]) {
            if(!vis[v]) {
                ans[v] += ans[u];
                dfs2(v);
            }
        }
    }
}


/*
***** Testcases *****
case =1
input =4 3
1 2
1 3
2 4
1
output =2

case =2
input =6 5
1 2
1 3
2 4
3 5
3 6
4
output =4

case =3
input =4 3
1 2
1 3
2 4
3
output =3

case =4
input =5 5
2 1
2 3
1 3
4 1
4 5
3
output =2

case =5
input =5 5
2 1
2 3
1 3
4 1
4 5
1
output =2

case =6
input =8 11
1 4
4 6
4 8
6 8
3 5
4 7
5 7
4 5
3 4
2 5
2 7
4
output =-1

case =7
input =8 9
1 3
1 8
2 8
2 4
3 5
8 5
4 6
5 6
5 7
1
output =-1

case =8
input =8 9
1 3
1 8
2 8
2 4
3 5
8 5
4 6
5 6
5 7
7
output =1

*/