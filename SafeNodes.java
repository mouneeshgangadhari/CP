/*
In the mystical land of Graphonia, there exists an ancient forest known as the Enchanted Forest. 
The forest is represented by a graph with N nodes (0 to N-1). 
Where each node has neighboring nodes. 
Some nodes are terminal (with no outgoing edges), 
while others are safe (all paths lead to terminal nodes or other safe nodes).

Your task is to find and map all safe nodes in the forest. 
Return an array of safe nodes, sorted in ascending order.

Input format
------------
Line 1: Number of nodes, N
Next N lines of input represents space seperated edges of each node starting from 0 to N-1

Note: if the edge is -1 then it represent there is no edge for that particular node

Output format
-------------
List of safe nodes in ascending order


Sample Input 1
---------------
7
1 2
2 3
5
0
5
-1
-1

Sample output 1
---------------
[2, 4, 5, 6]
Explanation: Nodes 5 and 6 are terminal nodes, and every path starting at nodes 2, 4, 5, and 6 leads to either node 5 or 6.


Example 2:

Sample Input 2
--------------
5
1 2 3 4
1 2
3 4
0 4
-1

Sample Output 2
---------------
[4]
  
Explanation: Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.

*/
import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rGraph.add(new ArrayList<>());
        }
        // Reversing the graph direction
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                rGraph.get(v).add(u);
            }
        }
        boolean[] safeness = new boolean[n];
        int[] outDegrees = new int[n];
        for (int u = 0; u < n; u++) {
            outDegrees[u] = graph[u].length;
        }
        // Finding terminal nodes
        Queue<Integer> frontier = new LinkedList<>();
        for (int u = 0; u < n; u++) {
            if (outDegrees[u] == 0) {
                frontier.add(u);
            }
        }        
        // Topological sorting
        while (!frontier.isEmpty()) {
            int u = frontier.poll();
            safeness[u] = true;
            for (int v : rGraph.get(u)) {
                outDegrees[v]--;
                if (outDegrees[v] == 0) {
                    frontier.add(v);
                }
            }
        }
        // Collecting safe nodes
        List<Integer> result = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            if (safeness[u]) {
                result.add(u);
            }
        }
        return result;
    }
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		int[][] graph=new int[n][];
		for(int i=0;i<n;i++)
		{
			String arr[]=sc.nextLine().split(" ");
			if(arr[0].equals("-1"))
			{
				graph[i]=new int[0];
				continue;
			}
			graph[i]=new int[arr.length];
			for(int j=0;j<arr.length;j++)
				graph[i][j]=Integer.parseInt(arr[j]);
		}
        System.out.println(new Solution().eventualSafeNodes(graph));
	}
}

/*
Test cases

case=1
input=7
1 2
2 3
5
0
5
-1
-1
output=[2, 4, 5, 6]

case=2
input=5
1 2 3 4
1 2
3 4
0 4
-1
output=[4]

case=3
input=6
1 2
2 3
3 4
4 5
5 0
-1
output=[5]

case=4
input=7
4 5
3 4
2 3
-1
5
-1
2
output=[0, 1, 3, 4, 5]

case=5
input=7
1 2
2 3
3 4
4
5 0
-1
-1
output=[5, 6]

case=6
input=8
1 2
2 3
3 4
4 5
5 6
6 7
7
-1
Output=[0, 1, 2, 3, 4, 5, 6, 7]
*/