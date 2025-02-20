/*You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6

*/
import java.util.Scanner;
class LatestRelease{
	public static int latestRelease(String version1, String version2) {
		String[] levels1 = version1.split("-");
		String[] levels2 = version2.split("-");	
		int length = Math.max(levels1.length, levels2.length);
		for (int i=0; i<length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}
		return 0;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String[] release=sc.nextLine().split(" ");
		String latest=release[0];
		for(int i=1;i<release.length;i++){
			int result=latestRelease(latest,release[i]);
			if(result==0){
				if((latest.compareTo(release[i]))>0)
					latest=release[i];
			}
			else if(result==-1)
			{
				latest=release[i];
			}
		}
		System.out.println(latest);
	}
}
/*

==== testcases ====
case =1
input =1-2 1-2-3-0-0 1-2-3
output =1-2-3

case =2
input =1-2 1-2-3-0-0 1-2-3 1-2-3-4 1-2-3-4-5-6
output =1-2-3-4-5-6

case =3
input =5-4-3-2-1 5-4-3-2-1-0-0-0 5-4-3-2-2 5-4-3-2-2-1 5-4-3-4-0 5-4-3-2-4-1-5-6
output =5-4-3-4-0

case =4
input =6-2-7-8-9-4-6-3-5-2-3-4-8 6-2-7-8-9-4-5-3-7-2-1 6-2-7-8-9-4-7-5-4 6-2-7-8-9-4-7-3-5-2-3-4-8 6-2-7-8-9-4-7-5-3-4-8 6-2-7-8-9-4-6-3-5-1-4-6-8
output =6-2-7-8-9-4-7-5-4

case =5
input =6-7-8-9-5-4-2-3 6-7-8-9-5-4-3-2-1 6-7-8-9-5-4-2-5 6-7-8-9-5-4-3-2-4 6-7-8-9-5-4-3-1 6-7-8-9-5-4
output =6-7-8-9-5-4-3-2-4

case =6
input =5-6-3 5-3-5 5-0-0 5-7-4 5-8-3 5-8-4 5-5-6-6 5-7-8-6 5-8-6-3 5-8-6-3-0-0 5-6-8-4-3-2
output =5-8-6-3

case =7
input =5-4-5-9-12 4-8-7-3-9-5 5-4-5-7-2 4-8-7-3-9-5-6 5-6-3-4-3-5 5-3-5-6-4-3 5-6-3-4-5-0 5-4-4-3-2 5-6-3-1-2 5-4-3-5-6 5-5-6-6
output =5-6-3-4-5-0

case =8
input =5-4-5-9-12 4-8-7-3-9-5 5-4-5-7-2 4-8-7-3-9-5-6 5-6-3-4-3-5 5-3-5-6-4-3 5-4-4-3-2 5-6-3-1-2 5-4-3-5-6 5-5-6-6 5-2-7-8-9-4-6-3-5-2-3-4-8 5-2-7-8-9-4-5-3-7-2-1 5-2-7-8-9-4-7-5-4 5-2-7-8-9-4-7-3-5-2-3-4-8 5-4-3-2-1 5-4-3-2-1-0-0-0 5-4-3-2-2 5-4-3-2-2-1 5-4-3-4-0 5-4-3-2-4-1-5-6
output =5-6-3-4-3-5


*/
