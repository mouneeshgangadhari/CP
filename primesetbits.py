'''******DO NOT USE bin()to solve this problem******

Input two integers x and y (1 <= x <= y <= 10**6).

Find and display the count of numbers in the inclusive range "x to y" having a prime number of set bits in their binary representation.

The number of set bits an integer has is the number of 1's present when written in binary.
For example, 21 written in binary is 10101, which has 3 set bits.

Example 1:
Input: 6
10
Output: 4
Explanation:
6  -> 110 (2 set bits, 2 is prime)
7  -> 111 (3 set bits, 3 is prime)
8  -> 1000 (1 set bit, 1 is not prime)
9  -> 1001 (2 set bits, 2 is prime)
10 -> 1010 (2 set bits, 2 is prime)
4 numbers have a prime number of set bits.

Example 2:
Input:10
15
Output:5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
5 numbers have a prime number of set bits.
'''
def prime(n):
    if n<=1:
        return False
    if n<=3:
        return True
    if n%2==0 or n%3==0:
        return False
    i=5
    while i*i <= n:
        if n %i==0 or n%(i+2)==0:
            return False
        i+=6
    return True

def help(n,m):
    x=0
    for i in range(n,m+1):
        c=0
        y=i
        while(y!=0):
            if(y&1==1):
                c=c+1
            y=y>>1
        if(prime(c)):
            x=x+1
    return x

n=int(input())
m=int(input())
print(help(n,m))