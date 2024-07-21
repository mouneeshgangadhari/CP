/*
Find the bridges in the given graph

Sample Input-1:
---------------
4 
3
0 1
0 2
1 3

Sample Output-1:
----------------
1 3
0 1
0 2

Sample input-2
5 
5
1 0
1 2
0 2
3 0
3 4
output =
3 4
0 3



*/
import java.util.*;

class FindingBridges 
{
    private int V;   // No. of vertices    
	// Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;

	// Constructor
	FindingBridges (int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);    //Add v to w's list
    }

    // A recursive function that finds and prints bridges     
	// using DFS traversal
    // u --> The vertex to be visited next
    // visited[] --> keeps track of visited vertices
    // disc[] --> Stores discovery times of visited vertices (when for the first time that particular vertex is reached)
	// low[ ] --> to keep track of the lowest possible time by which we can reach that vertex 'other than parent'
	// so that if edge from parent is removed can the particular node can be reached other than parent.
    // parent[] --> Stores parent vertices in DFS tree
    
    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[])
    {
        // Mark the current node as visited
        visited[u] = true;

		System.out.println("bridgeUtil u " + u + " parent " + Arrays.toString(parent));
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u
			System.out.println("u " + u + " v " + v + " visited[v] " + visited[v]);

            // If v is not visited yet, then make it a child of u in DFS tree and recur for it.
            if (!visited[v])
            {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);

				// Check if the subtree rooted with v has a connection to one of the ancestors of u
				// this arises when a node can be visited by more than one node, 
				// but low is to keep track of the lowest possible time so we will update it
                low[u]  = Math.min(low[u], low[v]);

				System.out.println("u " + u + " v " + v + " low " + Arrays.toString(low) + " disc " + Arrays.toString(disc));

				// If the lowest vertex reachable from subtree under v is below u in DFS tree, 
				// then u-v is a bridge
                if (low[v] > disc[u])
                    System.out.println(u+" "+v);
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);

			// System.out.println("low " + Arrays.toString(low) + " disc " + Arrays.toString(disc));
        }
    }

    // DFS based function to find all bridges. It is recursive
    void bridge()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        // Initialize parent and visited arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = -1;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges  in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                bridgeUtil(i, visited, disc, low, parent);
    }

    public static void main(String args[])
    {      
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        
		FindingBridges g = new FindingBridges (v);
        for(int i=0;i<e;i++)
        {
            int end1=sc.nextInt();
            int end2=sc.nextInt();
            g.addEdge(end1,end2);
        }
		System.out.println("Bridges in graph");     
        g.bridge();       
    }
}


/*
***** Testcases *****
case =1
input =4 
3
0 1
0 2
1 3

output =1 3
0 1
0 2

case =2
input =6 
5
0 1
0 2
1 3
2 4
2 5
output =
1 3
0 1
2 4
2 5
0 2

case =3
input =5 
5
1 0
1 2
0 2
3 0
3 4
output =
3 4
0 3
case =4
input =8 11
0 3
3 5
3 7
5 7
2 4
3 6
4 6
3 4
2 3
1 4
1 6
output =0 3

case =5
input =8
9
0 2
0 7
1 7
1 3
2 4
7 4
3 5
4 5
4 6
output =4 6

*/