/*


In a school, there are N students in a class numbered from 1,2,3..N.
During the play time in school, drill master wants to split them into 
two teams based on their interest.

If the pair of students want to play opposite each other, drill master should 
put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
put A and B in same team.
 
You need to find out wether is it possible to put everyone into two teams or not
return true if it is possible, otherwise false.

Input Format:
----------------
Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

Output Format:
------------------
Print a boolean result.


Sample Input-1:
-------------------
5
4
1 2
1 3
2 4
3 5

Sample Output-1:
---------------------
true

Explanation: 
----------------
team1 [1,4,5], team2 [2,3]


Sample Input-2:
-------------------
5 
5
1 2
2 3
3 4
4 5
1 5

Sample Output-2:
---------------------
false
*/
import java.util.*;
class Solution {
    List<Integer>[] adj;
    int[] colors;
    public boolean splitintoGroups(int n, int[][] pairs) {
        n++;
        adj = new List[n];
        colors = new int[n]; 
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }    
        for(int[] dis: pairs){
            int a = dis[0];
            int b = dis[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int i = 0; i < n; i++){
            if(colors[i] == 0 && !dfs(i, 1)) return false;
        }
        return true;
    }
    public boolean dfs(int node, int color){
        if(colors[node] == color) return true;
        int nextColor = (color == 1 ? 2: 1);
        if(colors[node] == nextColor) return false;
        colors[node] = color;
        for(int enemy: adj[node]){
            if(!dfs(enemy, nextColor)) return false;
        }
        return true;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int[][] ar = new int[P][2];
		for(int i=0;i<P;i++){
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
		}
		System.out.println(new Solution().splitintoGroups(N,ar));
	}
}
/*
=== testcases ===
case =1
input =4 3
1 2
1 3
2 4
output =true

case =2
input =5 5
1 2
2 3
3 4
4 5
1 5
output =false

case =3
input =3 3
1 2
1 3
2 3
output =false

case =4
input =10 7
1 2
1 3
1 4
2 5
6 7
8 9
6 10
output =true

case =5
input =15 11
1 15
1 9
2 14
3 13
4 10
4 11
5 13
6 7
7 8
8 9
10 11
output =false

case =6
input =15 11
1 15
2 14
3 13
4 12
5 11
6 10
7 9
1 8
6 9
5 7
2 9
output =true

case =7
input =20 15
1 2
2 3
3 20
4 17
5 16
7 8
9 11
12 14
6 15
9 13
10 18
4 19
8 18
4 11
7 14
output =true

case =8
input =15 15
1 2
2 3
3 4
4 5
6 7
7 8
8 9
9 10
11 12
12 13
13 14
14 15
5 6
10 11
1 15
output =false
*/

