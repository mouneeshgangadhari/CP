// A Java program to print topological
// sorting of a graph using indegrees

import java.util.*;

// Class to represent a graph
class Graph 
{
	// No. of vertices
	int V;

	// An Array of List which contains references to the Adjacency List of each vertex
	List<Integer> adj[];
	// Constructor
	public Graph(int V)
	{
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	// Function to add an edge to graph
	public void addEdge(int u, int v)
	{
		adj[u].add(v);
	}

	/*
	Step-1: Compute in-degree (number of incoming edges) for each of the vertex present 
	in the DAG and initialize the count of visited nodes as 0.

	Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
	
	Step-3: Remove a vertex from the queue (Dequeue operation) and then. 
 
	Increment the count of visited nodes by 1.
	Decrease in-degree by 1 for all its neighbouring nodes.
	If the in-degree of neighbouring nodes is reduced to zero, then add it to the queue.

	Step 4: Repeat Step 3 until the queue is empty.

	Step 5: If the count of visited nodes is not equal to the number of nodes in the 
	graph then the topological sort is not possible for the given graph.
	*/

	public void topologicalSort()
	{
		// Create a array to store indegrees of all
		// vertices. Initialize all indegrees as 0.
		int indegree[] = new int[V];

		// Traverse adjacency lists to fill indegrees of
		// vertices. This step takes O(V+E) time
		for (int i = 0; i < V; i++) 
		{
			ArrayList<Integer> temp	= (ArrayList<Integer>)adj[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}

		for (int i = 0; i < V; i++) 
		{
			System.out.println("vertex " + i + " indegree " + indegree[i]);
		}

		// Create a queue and enqueue all vertices with indegree 0
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) 
		{
			if (indegree[i] == 0)
				q.add(i);
		}

		// Initialize count of visited vertices
		int cnt = 0;

		// Create a list to store result (A topological ordering of the vertices)
		List<Integer> topOrder = new ArrayList<Integer>();
		while (!q.isEmpty()) 
		{
			// Extract front of queue (or perform dequeue)
			// and add it to topological order
			int u = q.poll();
			System.out.println("Queue item " + u);
			topOrder.add(u);

			// Iterate through all its neighbouring nodes of 
			// dequeued node u and decrease their in-degree by 1
			for (int node : adj[u]) 
			{
				System.out.println("adjacent items " + node);
				// If in-degree becomes zero, add it to queue
				if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

		// Check if there was a cycle
		if (cnt != V) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		// Print topological order
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}
}

class test 
{
	public static void main(String args[])
	{
		// Create a graph 

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Graph g = new Graph(n);
        int e=sc.nextInt();
		for(int i=0;i<e;i++){
			int e1=sc.nextInt();
			int e2=sc.nextInt();
			g.addEdge(e1,e2);
		}

		System.out.println("Following is a Topological Sort");
		g.topologicalSort();
	}
}

/*test cases
case=1
input=6
6
5 2
5 0
4 0
4 1
2 3
3 1
output=4 5 2 0 3 1

case=2
input=5
5
4 0
4 1
2 3
3 1
2 0
output=2 4 3 0 1

case=3
input=8
8
4 0
1 5
2 3
6 7
4 5
3 1
2 0
5 6
output=2 4 3 0 1 5 6 7
*/