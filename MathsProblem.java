
/*
/*
Mr. Uday, a mathematics teacher, has assigned a task to his students. The challenge is to determine the shortest length of a contiguous subset within an array of positive integers. This subset must have a sum exceeding a specified value, denoted as "k". Students should find length of the subset,if no such subset exists, the program should output 0.
With your programming skills write a program to solve this.


input format: an integer n
             n number of integers
			 an integer (k)
output format: an integer( length of subset)

For example,
Example 1:
Input=8
1 2 3 4 5 6 7 8
20
Output=3
Explanation: The smallest subarray with sum > 20 is {6, 7, 8}  

Example 2:
Input=8
1 2 3 4 5 6 7 8
7
Output= 1
Explanation: The smallest subarray with sum > 7 is {8}

Example 3:
Input=8
1 2 3 4 5 6 7 8
21
Output= 4
Explanation: The smallest subarray with sum > 21 is {4, 5, 6, 7}

Example 4:
Input=8
1 2 3 4 5 6 7 8
40
Output=0
*/
*/
public class MathsProblem {
    public static int help(int[] a,int k,int n){
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int c=0;
            for(int j=0;j<i;j++){
                c=c+a[j];
            }
            if(c>k){
                min=Math.min(min,i);
            }
            for(int j=i;j<n;j++){
                c=c+a[j]-a[j-i];
                if(c>k){
                    min=Math.min(min,i);
                }
            }
            
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(help(a,k,n));
    }
}
