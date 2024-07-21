/*
 * Mr. Kevin lives in a city that consists of n juntions numbered from 
0 to n - 1 with bi-directional roads between some juntions. 
The inputs are generated such that you can reach any juntion from any 
other juntion and that there is at most one road between any two juntions.

You are given an integer number of junctions (n) and m roads data 
where each road data = [ui, vi, timei] means that there is a road 
between juntions ui and vi that takes timei minutes to travel. 
Your task is to find in how many ways Mr. Kevin can travel 
from juntion 0 to juntion n - 1 in the shortest amount of time.
Since the answer may be large, return it modulo 10^9 + 7.

Input format
------------
An integer N, represents number of junctions
An integer M, represents number of roads
Next M lines, 3 integers (ui vi timei) representing each road data

Output format
-------------
An integer, represents number ways Kevin can reach from juntion 0 to 
juntion n - 1 in the shortest amount of time

Example 1:
----------
Input=
7
10
0 6 7
0 1 2
1 2 3
1 3 3
6 3 3
3 5 1
6 5 1
2 5 1
0 4 5
4 6 2
Output= 
4

Explanation: The shortest amount of time it takes to go from juntion 0 
to juntion 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 -> 6
- 0 -> 4 -> 6
- 0 -> 1 -> 2 -> 5 -> 6
- 0 -> 1 -> 3 -> 5 -> 6

Example 2:
-----------
Input=
2
1
1 0 10
Output=
1

Explanation: There is only one way to go from juntion 0 to juntion 1, 
and it takes 10 minutes.
 

Constraints:
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two juntions.
You can reach any juntion from any other juntion.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class destinationpaths {
    private static final int MOD = 1000000007;
    
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int u = (int) current[0];
            long d = current[1];
            
            if (d > dist[u]) continue;
            
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                long time = neighbor[1];
                
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v, dist[v]});
                } else if (dist[u] + time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] roads = new int[m][3];
        
        for (int i = 0; i < m; i++) {
            roads[i][0] = sc.nextInt();
            roads[i][1] = sc.nextInt();
            roads[i][2] = sc.nextInt();
        }
        
        destinationpaths sol = new destinationpaths();
        System.out.println(sol.countPaths(n, roads));
    }
}
