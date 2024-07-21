'''
Input an integer List A(0-indexed) and an integer X.

We can calculate the score of every subArray as shown bellow.

The score of a subList (i, j) is defined as min * (j - i + 1), where min is smallest among subList. 

A nice subList is a subList where i <= X <= j.

Return the maximum possible score of a nice subList.

Example 1:
Input: 
1 4 3 7 4 5 //A
3			//X
Output: 15
Explanation: 
The optimal subList is (1, 5) with a score of 
min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15. 

Example 2:
Input: 
5 5 4 5 4 1 1 1
0
Output: 20
Explanation: The optimal subList is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.

YOU MAY USE FOLLOWING CODE SEGMENT TO SOLVE ABOVE PROBLEM

def maximumScore(nums, k):
    #WRITE YOUR CODE HERE
	
A=[int(i) for i in input().split()]
X=int(input())
print(maximumScore(A,X))

'''
def maximumScore(nums, k):
    n = len(nums)
    min_value = nums[k]
    max_score = min_value
    left = k
    right = k
    
    while left > 0 or right < n - 1:
        if left == 0:
            right += 1
        elif right == n - 1:
            left -= 1
        elif nums[left - 1] > nums[right + 1]:
            left -= 1
        else:
            right += 1
        min_value = min(min_value, nums[left], nums[right])
        max_score = max(max_score, min_value * (right - left + 1))
        
    return max_score

A = [int(i) for i in input().split()]
X = int(input())
print(maximumScore(A, X))

