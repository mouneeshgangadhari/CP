'''
MyStore is a newly launched super market. 
There are n items to sell. Each item has a price. 
However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

Input an integer array 'price' where 
price[i] is the price of the ith item.

Input an integer array 'needs' where 
needs[i] is the number of pieces of the ith item you want to buy.

Input m(number of affers available).
Input an nested array 'offer' of size m where 
offer[i] is of size n + 1 and 
offer[i][j] is the number of pieces of the jth item in the ith offer and 
offer[i][n] is offer price.

Return the lowest price you have to pay for exactly certain items as given, 
where you could make optimal use of the special offers. 
You are not allowed to buy more items than you want, 
even if that would lower the overall price. 
You could use any of the special offers as many times as you want.

Sample Test Cases:
case=1
input=2		#n
2 5			#price
2			#m
3 0 5		#m offers
1 2 10
3 2			#needs
output=14
Explanation: There are two kinds of items, A and B. 
Their prices are Rs.2 and Rs.5 respectively. 
In special offer 1, you can pay Rs.5 for 3A and 0B
In special offer 2, you can pay Rs.10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay Rs.10 for 1A and 2B (special offer #2), and Rs.4 for 2A.

case=2
input=3
2 3 4
2
1 1 0 4
2 2 1 9
1 2 1
output=11
Explanation: The price of A is Rs.2, B is Rs.3 and C is Rs.4. 
You can pay Rs.4 for 1A and 1B, 
You can pay Rs.9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay Rs.4 for 1A and 1B (special offer #1), and Rs.3 for 1B, Rs.4 for 1C. 
You cannot add more items, though only Rs.9 for 2A ,2B and 1C.

Constraints:
n == price.length == needs.length
1 <= n <= 6
0 <= price[i], needs[i] <= 10
1 <= offer.length <= 100
offer[i].length == n + 1
0 <= offer[i][j] <= 50
'''