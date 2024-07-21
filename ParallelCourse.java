/*
You are given an integer N which denotes the number of courses numbered from 1 to N and a matrix ‘prerequisites’,
in which each row contains exactly two integers ‘A’ and ‘B’ which represents the course ‘A’ 
has to be studied in some semester before studying course ‘B’.

In one semester, you can take at most k courses as long as you have taken all the prerequisites in the previous semesters for the courses you are taking.

You are supposed to find the minimum number of semesters required to study all the courses. 
If it is impossible to study all the courses, then return -1.

Input Format:
The first line represents N, which denotes the number of courses
The second line represents M, which denotes the number of rows of the matrix prerequisites.
The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], 
denoting that prerequisites[i][0] has to be studied before prerequisites[i][1].
Last line k, denotes number of courses can be taken in a semester.

Output Format:
Print the minimum number of semesters required to study all the courses

Sample Input 1
--------------
4
3
2 1
3 1
4 1
2

Sample output 1
---------------
3


Explanation: 
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 1.
In the third semester, you can take course 4.

Sample input 2
--------------
4
3
1 3
2 3
3 1
3
Sample output 2
----------------
-1

Constraints:
1<= N <= 50
1<=k<=N
1 <= prerequisites[i][0], prerequisites[i][1] <= N
Prerequisites[i][0] != prerequisites[i][1], for any valid i
*/

import java.util.*;
class ParallelCourses 
{
	public int minimumSemesters(int numCourses, int[][] prerequisites,int maxCourses) 
	{
        // create an adjacency list to represent the graph
		int graph[][]=new int[numCourses+1][numCourses+1];
		int[] indegree = new int[numCourses+1];

        // populate the adjacency list using the prerequisites array
       	for (int[] prerequisite : prerequisites) 
		{
            int u = prerequisite[0];
            int v = prerequisite[1];
            graph[u][v]=1;
            indegree[v]++;
		}
 
		// Perform a topological sort to find the order in which the courses should be taken
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numCourses; i++) 
		{
            if (indegree[i] == 0) 
			{
                queue.offer(i);
            }
		}
		int semesters = 0;
		int coursesTaken = 0;
        while (!queue.isEmpty()) 
		{
            int coursesThisSemester = Math.min(queue.size(), maxCourses);
			//System.out.println("coursesThisSemester " + coursesThisSemester);
            for (int i = 0; i < coursesThisSemester; i++) 
			{
                int u = queue.poll();
                coursesTaken++;
				//System.out.println("u " + u + " coursesTaken " + coursesTaken);
                for (int v=1;v<=numCourses;v++) 
				{
					if(graph[u][v]==1 && --indegree[v] == 0)
						queue.offer(v);
                }
            }
            semesters++;
        }
		//System.out.println("coursesTaken " + coursesTaken + " numCourses " + numCourses);
        if (coursesTaken != numCourses) 
		{
            return -1; // cannot complete all courses
        }
        return semesters;
	}

	public static void main(String[] args) 
	{	Scanner s=new Scanner(System.in);
		int numCourses=s.nextInt();
		int c=s.nextInt();
		int prerequisites[][]=new int[c][2];
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<2;j++)
			{
				prerequisites[i][j]=s.nextInt();
			}
		}
		int maxCourses=s.nextInt();
		ParallelCourses p=new ParallelCourses();
		System.out.println(p.minimumSemesters(numCourses, prerequisites, maxCourses)); 
	}
}


/*
=== testcases ===
case =1
input=4
3
2 1
3 1
4 1
3
output=2

case =2
input =3
2
1 3
2 3
2
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
2
output =7

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
3
output =5

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
2
output =9

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
4
output =8

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
1
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
4
output =10

case=9
input=4
3
2 1
3 1
1 4
2
output=3

case=10
input =4
3
1 3
2 3
3 1
3
output =-1

case=11
input=5
4
2 1
3 1
4 1
5 1
3
output=3

case=12
input=3
2
2 1
3 1
2
output=2
*/
