/*
 * /*
Consider a pair of integers, (a,b). The following operations can be performed 
on (a,b) in any order, zero or more times:
	- (a,b) -> ( a+b, b )
	- (a,b) -> ( a, a+b )

For example, starting with (1,1), perform the operation (1, 1+1) to get (1,2), 
perform the operation (1+2, 2) to get (3,2), and perform the operation (5,2). 
Alternatively the first operation could be (1+1, 1) to et (2,1) and so on.

Your task is to build a function must return a string that denotes whether you 
can convert (a,b) to (c,d) by performing zero or more operations specified 
above? or not. 

If it is possible, return true, otherwise false.

NOTE: 
1<= a,b,c,d <= 1000

Input Format:
-------------
Line-1: Two space separated integers, a,b
Line-2: Two space separated integers, c,d

Output Format:
--------------
Return a boolean value.


Sample Input-1:
---------------
1 2
5 4

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 3
10 7

Sample Output-2:
----------------
false
*/

import java.util.*;

class convert {
    public static boolean canReach(int a, int b, int c, int d) {
        if (a == c && b == d)
            return true;
        if (a > c || b > d)
            return false;
        return canReach(a + b, b, c, d) || canReach(a, a + b, c, d);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println(canReach(a, b, c, d));
    }
}
