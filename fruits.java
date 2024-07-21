/*You are visiting a farm that has a single row of fruit trees arranged from left to right.
 The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample cases:

case 1:
Input: 
3
1 2 1
Output: 3
Explanation: We can pick from all 3 trees.

Case  2:
Input: 
4
0 1 2 2 
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

case 3:
Input: 
5
1 2 3 2 2
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/

import java.util.*;
class Test {
    public int totalFruit(int[] fruits) {
        // Hash map 'basket' to store the types of fruits.
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, right;
        
        // Add fruit from left side of the window.
        for (right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            // If the current window has more than 2 types of fruit,
            // we remove one fruit from the left index (left) of the window.
			System.out.println("basket size " + basket.size());
            if (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }
        }
        System.out.println(right + " " + left);
        // Once we finish the iteration, the indexes left and right 
        // stands for the longest valid subarray we encountered.
        return right - left;
    }
  public static void main(String args[])
	{
		 Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println(new Test().totalFruit(ar));
	}
}
/*Test Cases
case =1
input=
4
0 1 2 2
output=3

case =2
input=
8
1 1 1 2 3 3 3 3
output= 5

case 3=
input=
10
1 2 2 2 2 3 3 3 4 4
output= 7

case 4=
input=
15
1 1 1 1 2 2 2 2 2 2 2 2 3 3 3
output= 12

case 5=
input=25
1 1 1 1 1 1 2 2 2 2 2 2 3 3 3 3 3 2 2 2 2 2 2 2 2
output=19

case 6=
input=36
1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 3 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
output=25

case 7=
input=45
2 2 2 2 2 2 2 1 1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 
output=31

case 8=
input= 25
1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 3 1 2 1 2 1 2 1 
output=17
*/

