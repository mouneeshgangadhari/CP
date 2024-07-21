/*

In the town of Harmonyville, friendship trees symbolize connections between people. Each tree represents an individual, and the edges connecting them denote friendships.
Given a frindship tree of n nodes labelled from 0 to n - 1, and n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the friendship tree, you can choose any node of the tree as the root.
 
The goal is to find the roots of the minimum height trees (MHTs) that strengthen the community bond.
When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. 

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Input Format:
-------------
Line-1: An integer N, number of nodes.
Next N-1 lines: Two space separated integers, ai and bi.

Output Format:
--------------
List of all MHTs' root labels

Example 1:

Sample Input 1
--------------
4
1 0
1 2
1 3

Sample Output 1
---------------
[1]

Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.


Example 2:

Sample Input 2
--------------
6
3 0
3 1
3 2
3 4
5 4

Sample Output 1
---------------
[3,4]

*/
import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] degree = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
            ++degree[a];
            ++degree[b];
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.clear();
            for (int i = q.size(); i > 0; --i) {
                int a = q.poll();
                ans.add(a);
                for (int b : g[a]) {
                    if (--degree[b] == 1) {
                        q.offer(b);
                    }
                }
            }
        }
        return ans;
    }
	public static void main(String args[]) 
	{
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[][] edges = new int[N-1][2];

        for (int i = 0; i < N-1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
        }
        System.out.println(new Solution().findMinHeightTrees(N, edges));
    }
}

/* Test cases
case=1
input=4
1 0
1 2
1 3
output=[1]

case=2
input=6
3 0
3 1
3 2
3 4
5 4
output=[3, 4]

case=3
input=8
0 1
1 2
1 2
2 4
2 5
3 6
3 7
output=[3]

case=4
input=5
0 1
0 2
1 3
1 4
output=[0, 1]

case=5
input=6
0 1
1 2
2 3
3 4
4 5
output=[2, 3]

case=6
input=9
1 2
2 4
3 4
4 5
5 6
6 7
7 8
0 1
output=[4, 5]

*/