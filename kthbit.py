'''
We input N and K. 
N is Row number.
We start by writing 0 in the 1st row.
In every subsequent row, we look at the previous row and replace 
each occurrence of 0 with 01, and each occurrence of 1 with 10.
Return the Kth (1-indexed) symbol in the Nth row.

For example, 
If N = 4 and K = 5, the 4 rows will be
0
01
0110
01101001
5th symbol in 4th row is 1.

Sample Test Cases:
case=1
input=2
2
output=1

case=2
input=4
5
output=1

case=3
input=5
6
output=0
'''
def findKthBit(N, K):
    bit = 0
    for b in bin(K - 1)[2:]:
        if b == '1':
            bit ^= 1
    return bit

N = int(input())
K = int(input())

print(findKthBit(N, K))