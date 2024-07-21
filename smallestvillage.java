/*There are n villages numbered from 0 to n-1. Given the array edges where 
edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted 
edge between villages fromi and toi, and given the integer distanceThreshold.

Return the village with the smallest number of villages that are reachable 
through some path and whose distance is at most distanceThreshold, If there 
are multiple such villages, return the village with the greatest number.

Notice that the distance of a path connecting villages i and j is equal 
to the sum of the edges' weights along that path.

Input Format
------------
An integer N, represents number of villages
An integer M, represents number of edges
Next M lines, 3 integers each line representing fromi,toi and weighti of each path 
An integer T, represents distance Threshold

Output Format
-------------
An integer, which represent the village

Example 1:
-----------
Input=
4
4
0 1 3
1 2 1
1 3 4
2 3 1
4
Output=
3

Explanation: The figure above describes the graph. 
The neighboring villages at a distanceThreshold = 4 for each village are:
village 0 -> [village 1, village 2] 
village 1 -> [village 0, village 2, village 3] 
village 2 -> [village 0, village 1, village 3] 
village 3 -> [village 1, village 2] 
villages 0 and 3 have 2 neighboring villages at a distanceThreshold = 4, 
but we have to return village 3 since it has the greatest number.

Example 2:
----------
Input=
5
6
0 1 2
0 4 8
1 2 3
1 4 2
2 3 1
3 4 1
2
Output=0

Explanation: The figure above describes the graph. 
The neighboring villages at a distanceThreshold = 2 for each village are:
village 0 -> [village 1] 
village 1 -> [village 0, village 4] 
village 2 -> [village 3, village 4] 
village 3 -> [village 2, village 4]
village 4 -> [village 1, village 2, village 3] 
The village 0 has 1 neighboring village at a distanceThreshold = 2.
 

Constraints:
------------
2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
*/


import java.util.*;
class smallestvillage{
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 100000); 
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int resultCity = -1;
        int minReachable = n;
        
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (reachableCount < minReachable || (reachableCount == minReachable && i > resultCity)) {
                minReachable = reachableCount;
                resultCity = i;
            }
        }
        
        return resultCity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        int T = sc.nextInt();
        System.out.println(findTheCity(N, edges, T));
    }
}