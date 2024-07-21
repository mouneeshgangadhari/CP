/*
EA Sports, developed a video game. They designed a game in such a way that, 
there are L number of levels from 1 to L. There are D number of dependencies
where each dependency[m] = [ Xm, Ym ], represents a prerequisite relationship,
that is, in order to play level-Ym, you must have completed the level-Xm.

In one day you can complete any number of levels as long as you 
have completed all the prerequisites levels in the game. 

You cannot play a level-Ym which has some prerequisite level-Xm on same day.

Write a program to display the minimum number of days to complete all the levels
in the game. If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of levels.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. 
On the second day, level-3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.

*/


import java.io.IOException;
import java.util.*;

class CompleteGame {
    private int maxPathLength = Integer.MIN_VALUE;
    private boolean hasCycle = false;

    public int minimumDays(int N, int[][] relations) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            graph.putIfAbsent(relation[0], new LinkedList<>());
            graph.get(relation[0]).add(relation[1]);
        }
        // Initialized with N+1 element to make indexing easier but we only need N
        int[] depth = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            dfs(i, visited, depth, graph);
        return hasCycle ? -1 : maxPathLength;
    }

    private int dfs(int root, boolean[] visited, int[] depth, HashMap<Integer, LinkedList<Integer>> graph) 
	{
		//System.out.println("root " + root + " depth[root] " + depth[root] + " visited[root] " + visited[root]);
        if (visited[root])
            hasCycle = true;
        if (depth[root] > 0 || hasCycle)
            return depth[root];
        visited[root] = true;
        int max = 0;
        // Find the longest path from the neighbor courses
        if (graph.containsKey(root)) {
            for (int neighbor : graph.get(root)) {
                max = Math.max(max, dfs(neighbor, visited, depth, graph));
            }
        }
        visited[root] = false;
        depth[root] = max + 1;
        maxPathLength = Math.max(maxPathLength, depth[root]);
        return depth[root];
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str;
        int levels, nrelations;
        levels = sc.nextInt();
        nrelations = sc.nextInt();
        int[][] relations = new int[nrelations][2];

        for (int i = 0; i < nrelations; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            relations[i][0] = a;
            relations[i][1] = b;
        }
        System.out.println(new CompleteGame().minimumDays(levels, relations));
    }
}


/*
=== testcases ===
case =1
input =3
3
1 3
2 3
3 1
output =-1

case =2
input =3
2
1 3
2 3
output =2

case =3
input =10
10
1 3
2 3
3 4
7 6
4 6
5 6
6 8
6 9
8 10
9 10
output =6

case =4
input =10
10
1 5
2 5
3 5
4 5
5 8
6 8
7 8
8 10
7 9
9 10
output =4

case =5
input =15
16
1 5
2 5
3 6
4 6
5 7
6 7
7 9
6 8
8 9
9 10
9 11
10 12
11 13
12 14
13 14
14 15
output =8

case =6
input =15
18
1 6
2 6
3 6
4 6
5 6
6 7
6 8
6 9
6 10
7 11
8 11
9 11
10 11
11 12
11 13
12 14
13 14
14 15
output =7

case =7
input =15
14
1 2
2 3
3 4
4 5
5 6
6 7
7 8
8 9
9 10
10 11
11 12
12 13
13 14
14 15
output =15

case =8
input =20
27
1 5
2 5
3 5
4 5
5 6
5 7
5 8
5 9
6 10
7 10
8 10
9 10
10 11
10 12
10 13
10 14
11 15
12 15
13 15
14 15
15 16
15 17
15 19
16 18
17 18
18 19
19 20
output =10

*/