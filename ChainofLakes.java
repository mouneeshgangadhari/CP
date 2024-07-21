/*
The Kakatiyas had built a very elaborate dam(water reservoir) system consisting of rows and rows of dams, all dams have the same capacity X. 

The first row has one dam, second row has two dams and 
third row has three dams and so on. like as below(V -> dam) 
				 V
				V V
               V V V
	        and so on..
There are altogether 100 rows. Water is drawn from the river at X liters each time.
The way water flows is that,
-> After the first drawing of water, the dam in the first row is filled.
-> After the second draw from the river, the dams in the second row are each half-filled.
-> After the third draw from the river, both dams in the second row are fully filled.
-> After the fourth draw from the river, the three dams in the third row are filled to the extent of 1/4, 1/2, and 1/4, respectively.


Given N draws from the river, determine how full the jth dam in the ith row.

The row is number from (0,0) onwards,
	The first row is row =0, dam = 0
	The second row is row =1, dams are 0 and 1. 
	so on...

Input Format:
-----------------
Three space seperated integers, N, i, j

Output Format:
------------------
Print a double value as result


Sample Input-1:
-------------------
2 1 1

Sample Output-1:
---------------------
0.5


Sample Input-2:
-------------------
4 2 2

Sample Output-2:
---------------------
0.25
*/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int r = sc.nextInt();
		int g = sc.nextInt();
		System.out.println(new Solution().champagneTower(p,r,g));

	}
}




/*


=== testcases ===
case =1
input =4 2 2
output =0.25

case =2
input =2 1 1
output =0.5

case =3
input =12 4 2
output =1.0

case =4
input =15031 89 31
output =0.7960484919340036

case =5
input =50 13 7
output =0.15869140625

case =6
input =1013 76 43
output =0.8315624343775103

case =7
input =283 40 19
output =0.47468486870639026

case =8
input =390 50 25
output =0.4660915887835415


*/