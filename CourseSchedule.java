/*
A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.


*/
import java.util.*;
import java.io.*;

class CourseSchedule 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
	{
        // just do topological ordering
        // n courses: ranging from 0 to n-1
        // also need to construct a graph according to the prerequisites
        List[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) 
			graph[i] = new ArrayList<Integer>();
        
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int u = p[1], v = p[0]; // from u->v
            graph[u].add(v);
            indegree[v]++;
        }
        
        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        
        // start from indegree=0, add the neighbors to the queue
        // if indegree becomes 0, add to queue
        while (!queue.isEmpty()) 
		{
            int u = queue.poll();
            order[index++] = u;
            for (int v : (List<Integer>)graph[u]) 
			{
                if (--indegree[v] == 0) 
				{
                    queue.add(v);
                }
            }
        }
        
        // in case there are cycles in the graph
        if (index < numCourses) 
			return new int[0];
        
        return order;
    }
	
	public static void main(String args[] ) throws IOException 
	{	
		Scanner sc=new Scanner(System.in);	
		int courses,nprerequisites;
		courses=sc.nextInt();
		nprerequisites=sc.nextInt();
		int[][] prerequisites=new int[nprerequisites][2];
		for(int i=0; i<nprerequisites; i++)
		{
			int a=sc.nextInt(),b=sc.nextInt();
			prerequisites[i][0]=a;
			prerequisites[i][1]=b;
		}  	   
		int[] result=new CourseSchedule().findOrder(courses, prerequisites);
		System.out.println(Arrays.toString(result));
	} 
}
/*
===== Testcases =====
case =1
input =4
3
1 2
3 0
0 1
output =[2, 1, 0, 3]

case =2
input =5
4
2 4
3 1
0 2
4 3
output =[1, 3, 4, 2, 0]

case =3
input =4
4
1 0
2 0
3 1
3 2
output =[0, 1, 2, 3]

case =4
input =5
5
0 1
1 2
2 3
3 4
4 0
output =[]

case =5
input =3
2
0 1
1 2
output =[2, 1, 0]

case =6
input =2
1
0 1
output =[1, 0]

case =7
input =6
6
4 0
5 0
4 1
3 2
3 5
1 3
output =[0, 2, 5, 3, 1, 4]
output =[0, 5, 2, 3, 1, 4]
*/