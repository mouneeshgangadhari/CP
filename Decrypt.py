'''
Given an array of integers which is a secret Code which is an array of integers.
You will be provided with a key K.

To decrypt the Code, you must replace every number. 

If K > 0, replace the ith number with the sum of the next K numbers.
If K < 0, replace the ith number with the sum of the previous K numbers.
If K == 0, replace the ith number with 0.

The next element of Code[N-1] is Code[0], and the previous element of Code[0] is Code[N-1] (N is Length of array).

Given the circular array Code and an integer key K, return the decrypted Code.
 
Example 1:
Input: 5 7 1 4
3
Output: 12 10 16 13
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted Code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Example 2:
Input: 1 2 3 4
0
Output: 0 0 0 0
Explanation: When k is zero, the numbers are replaced by 0. 

Example 3:
Input: 2 4 9 3
-2
Output: 12 5 6 13
Explanation: The decrypted Code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 
Constraints:
N == Code.length
1 <= N <= 100
1 <= Code[i] <= 100
-(N - 1) <= K <= N - 1
'''
def help(code, K):
    N = len(code)
    decrypted = [0] * N
    for i in range(N):
        if K > 0:
            for j in range(1, K + 1):
                decrypted[i] += code[(i + j) % N]
        elif K < 0:
            for j in range(1, abs(K) + 1):
                decrypted[i] += code[(i - j) % N]
    return decrypted
l=list(map(int,input().split(" ")))
k=int(input())
print(help(l,k))
'''
Test Cases:
case=1
input=5 7 1 4
3
output=12 10 16 13 

case=2
input=1 2 3 4
0
output=0 0 0 0 

case=3
input=2 4 9 3
-2
output=12 5 6 13 

case=4
input=1 2 3 4 5 6 7 8
2
output=5 7 9 11 13 15 9 3 

case=5
input=1 2 3 4 5 6 7 8
-3
output=21 16 11 6 9 12 15 18 

case=6
input=10 5 2 7 6 1 9 8
5
output=21 25 31 34 33 34 32 30

'''
