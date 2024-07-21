/*

Vicky, an expert in gaming software, lives in Australia and never compromises
in his life, a principle that he adheres to since his childhood. After 
long time he returns to India to establish a start-up gaming company. 

He meets his uncle Jalsa Kishore and Vicky tells about his plan. 
Jalsa Kishore came up with an idea for Vicky with a new game. 
He draws a grid with combination of 0’s and 1’s of size P X Q, where
we can reorganize the columns of the grid in any order. 

Jalsa Kishore says that build a grid such that we get the area of 
the greatest subunits within the grid where every unit of the sub grid is 1
after reorganizing the columns.

Now it’s your aim to write a method which prints the area of 
the greatest subunits within the grid according to idea of Jalsa Kishore.


Input Format:
-------------
Line-1: Two integers P and Q, size of the grid.
Next P lines: Q separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, area of the greatest subunits.


Sample Input-1:
---------------
3 4
1 0 1 0
0 1 1 1
0 1 0 1

Sample Output-1:
----------------
4

Explanation:
----------
After Reorganizing the columns, the grid looks like as follows:
1 0 0 1
0 1 1 1
0 1 1 0


Sample Input-2:
---------------
1 5
1 0 1 0 1

Sample Output-2:
----------------
3

Sample Input-3:
---------------
3 3
0 0 1
1 1 1
1 0 1

Sample Output-3:
----------------
4
*/

/*
Algorithm

1. Initialize m = matrix.length, n = matrix[0].length, 
	and the answer ans = 0.
2. Iterate row from 0 to m:
		Iterate col from 0 to n:
			If matrix[row][col] != 0 and row > 0:
				Add matrix[row - 1][col] to matrix[row][col].
		Create a copy of matrix[row] as currRow, then sort currRow in ascending order.
		Iterate i over the indices of currRow:
			 Update ans with currRow[i] * (i + 1) if it is larger.
3. Return ans.

*/

import java.util.*;
class puzzle1 {
    public int largestSubmatrix(int[][] matrix) {
        // Get matrix dimensions
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        
        // Step 1: Iterate through each row
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // Update element value based on the previous row
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }      
			
            // Step 2: Clone and sort each row
            int[] currRow = matrix[row].clone();
			System.out.println(Arrays.toString(matrix[row]));
            Arrays.sort(currRow);
			System.out.println(Arrays.toString(currRow));
            
            // Step 3: Calculate the area of the largest rectangle for each column
            for (int col = 0; col < n; col++) {
                int base = (n - col);
                int height = currRow[col];
                
                // Update the result with the maximum area
                result = Math.max(result, base * height);
				System.out.println("base "+base + " col " + col + " height " + height + " result " + result);

            }
        }
        
        // Step 4: Return the maximum area obtained
        return result;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] ar = new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				ar[i][j]=sc.nextInt();
		System.out.println(new puzzle1().largestSubmatrix(ar));
		
	
	}

}



/*


=== testcases ===
case =1
input =3 4
1 0 1 0
0 1 1 1
0 1 0 1
output =4

case =2
input =1 5
1 0 1 0 1
output =3

case =3
input =5 6
0 1 0 1 0 0
0 0 1 0 0 1
1 0 0 1 0 0
1 1 1 1 0 0
0 1 1 1 1 0
output =6

case =4
input =5 6
0 0 0 1 0 0
1 1 1 0 1 1
1 0 1 1 1 0
1 1 1 0 1 1
1 0 1 1 0 0
output =9

case =5
input =3 3
1 0 0
1 1 1
1 0 1
output =4

case =6
input =5 10
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
output =0

case =7
input =5 10
1 1 0 1 0 1 0 1 1 1
0 1 1 0 1 1 1 1 0 1
1 1 1 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1 1 1
1 0 1 1 0 1 1 1 1 0
output =15

case =8
input =8 8
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
output =64



*/