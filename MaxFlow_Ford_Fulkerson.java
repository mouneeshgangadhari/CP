/*
Given a graph which represents a flow network where every edge has a capacity. 
Also, given two vertices source 's' and sink 't' in the graph, find the maximum possible
flow from s to t with the following constraints:
	- Flow on an edge doesn't exceed the given capacity of the edge.
	- Incoming flow is equal to outgoing flow for every vertex except s and t.

Input Format:
------------------
Line-1: An integer V, number of vertices in graph
Next V lines: V space separated integers, graph[][], 
                       the adjacency matrix of the grpah.
Last Line: Two space separated integers, s and t, source and sink.

Output Format:
--------------------
Print an integer, the maximum possible flow of the graph


Sample Input:
------------------
6
0 16 13 0 0 0
0 0 10 12 0 0
0 4 0 0 14 0
0 0 9 0 0 20
0 0 0 7 0 4
0 0 0 0 0 0
0 5


Sample Output:
--------------------
23

Sample input 
-------------------
6
0 7 4 0 0 0
0 0 0 5 3 0
0 3 0 0 2 0
0 0 0 0 0 8
0 0 0 3 0 5
0 0 0 0 0 0
0 5

Sample Output:
--------------------
10

Sample input 
-------------------
6
0 8 3 0 0 0
0 0 0 9 0 0
0 0 0 7 4 0
0 0 1 0 0 2
0 0 0 0 0 5
0 0 0 0 0 0
0 5

Sample Output:
--------------------
6


*/

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.LinkedList;

/*
The following is simple idea of Ford-Fulkerson algorithm:

1) Start with initial flow as 0.
2) While there exists an augmenting path from the source to the sink:  
	a) Find an augmenting path using any path-finding algorithm, such as 
		breadth-first search or depth-first search.

	b) Determine the amount of flow that can be sent along the augmenting path, 
		which is the minimum residual capacity along the edges of the path.

	c) Increase the flow along the augmenting path by the determined amount.
3) Return the maximum flow.
*/

public class MaxFlow_Ford_Fulkerson {
	static int V; 
	boolean bfs(int rGraph[][], int s, int t, int parent[]) {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;
		while (queue.size() != 0) {
			int u = queue.poll();
			for (int v = 0; v < V; v++) {
				if (visited[v] == false && rGraph[u][v] > 0) {
					System.out.println("v " + v);
					if (v == t) {
						parent[v] = u;
						return true;
					}
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
					System.out.println(
							"parent " + u + " child " + v + " rGraph " + rGraph[u][v] + " visited[v] " + visited[v]);
				}
			}
		}
		return false;
	}
	int fordFulkerson(int graph[][], int s, int t) {
		int u, v;
		int rGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];
		int parent[] = new int[V];
		int max_flow=0;
		while (bfs(rGraph, s, t, parent)) {
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
				System.out.println("u " + u + " v " + v + " path_flow " + path_flow);
			}
			
			System.out.println("Minimum path flow " + path_flow);
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}
			max_flow += path_flow;
		}
		return max_flow;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int graph[][] = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				graph[i][j] = sc.nextInt();

		int s = sc.nextInt();
		int t = sc.nextInt();

		System.out.println(new MaxFlow_Ford_Fulkerson().fordFulkerson(graph, s, t));
	}
}
/*
 * Test cases
 * case =1
 * input=5
 * 0 1 1 0 0
 * 0 0 4 5 6
 * 0 0 0 0 2
 * 0 0 0 0 5
 * 0 0 0 0 0
 * 0 4
 * output=2
 * 
 * case =2
 * input=6
 * 0 10 10 0 0 0
 * 0 0 2 4 8 0
 * 0 0 0 0 9 0
 * 0 0 0 0 0 10
 * 0 1 0 6 0 10
 * 0 0 0 0 0 0
 * 0 4
 * output=17
 * 
 * case =3
 * input=4
 * 0 20 5 0
 * 10 0 2 7
 * 0 0 0 8
 * 0 0 0 0
 * 0 3
 * output= 14
 * 
 * case=4
 * input=6
 * 0 8 10 0 0 0
 * 0 0 0 3 7 0
 * 0 3 0 0 12 0
 * 0 0 0 0 0 10
 * 0 0 0 4 0 8
 * 0 0 0 0 0 0
 * 0 5
 * output=15
 * 
 * case =5
 * input=3
 * 0 10 20
 * 0 0 30
 * 0 0 0
 * 0 2
 * output=30
 * 
 * case =6
 * input=6
 * 0 11 12 0 0 0
 * 0 0 12 0 0 0
 * 0 1 0 0 11 0
 * 0 0 0 0 0 19
 * 0 0 0 7 0 4
 * 0 0 0 0 0 0
 * 0 5
 * output=11
 */