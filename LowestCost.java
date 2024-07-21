/*
There are n cities 0 to n-1 connected with various trasportation facilities. 
Input the cost of transportation between every two cities along with source and destination([fromCity,toCity,price]). There will not be any multiple transportations between two cities.

Also input three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

 

Input Format:
first line is an integer n(No. of cities)
second line is an input p(No. of prices we want to input)
next n lines, each line consists of 3 space separated integers fromCity, toCity and price
next three lines consists of source city(src), Destination city(dst) and Number of stops(k)

Output Format:
Display cheapest Price from source city to destination city

Sample Test Case-1:
4
5
0 1 100
1 2 100
2 0 100
1 3 600
2 3 200
0
3
1

Output: 700

Explanation:
The optimal path with at most 1 stop from city 0 to 3 has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Sample Test Case-2:
3
3
0 1 100
1 2 100
0 2 500
0
2
1

Output: 200

Explanation:
The optimal path with at most 1 stop from city 0 to 2 has cost 100 + 100 = 200.

Sample Test Case-3:
Input:
3
3
0 1 100
1 2 100
0 2 500
0
2
0
Output: 500
Explanation:
The optimal path with no stops from city 0 has cost 500.
 

Constraints:
1 <= n <= 100
0 <= costs.length <= (n * (n - 1) / 2)
costs[i].length == 3
0 <= fromCity, toCity < n
fromCity != toCity
1 <= price <= 1000
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

*/
import java.util.*;
class LowestCost {
    public int findLowestCost(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;
        
        for (int[] flight : flights) 
		{
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        K++;
        
        while (!queue.isEmpty() && K-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int currNode = curr[0];
                int currPrice = curr[1];
                if (adj.containsKey(currNode)) {
                    for (int[] neighbor : adj.get(currNode)) {
                        int newPrice = currPrice + neighbor[1];
                        if (newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice;
                            queue.offer(new int[]{neighbor[0], newPrice});
                        }
                    }
                }
            }
        }
        
        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
        int[][] costs = new int[p][3];
        for (int i = 0; i < p; i++) 
            for (int j = 0; j < 3; j++)
                costs[i][j] = sc.nextInt();
		int src = sc.nextInt();
		int dst = sc.nextInt();
		int k = sc.nextInt();
        System.out.println(new LowestCost().findLowestCost(n, costs, src, dst, k) );
	}
}


/*
Test Cases:
case=1
input=5
4
0 1 100
0 2 200
0 3 300
0 4 400
0
3
0
output=300

case=2
input=5
4
0 1 100
1 2 50
2 3 150
3 4 75
0
3
1
output=-1

case=3
input=4
5
0 1 100
0 2 300
1 2 150
1 3 250
2 3 50
0
3
1
output=350

case=4
input=11
25
0 1 10
1 2 15
2 3 7
3 4 6
4 5 20
5 6 8
6 7 9
7 8 12
8 9 13
9 10 4
1 4 25
4 7 30
7 10 20
1 2 20
1 3 15
2 7 60
2 10 70
4 10 50
5 9 40
3 4 100
3 8 120
5 10 110
6 8 75
8 10 60
6 10 30
1
10
5
output=71

case=5
input=6
10
0 5 100
0 2 40
1 2 30
2 5 70
0 1 25
2 3 20
3 5 25
4 5 35
2 4 35
3 5 60
1
5
1
output=100
*/