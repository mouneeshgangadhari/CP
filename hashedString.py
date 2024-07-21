'''
You are given a string 's' and the integers 'power', 'modulo', 'k', and 'hashValue'.

Return substring of s of length k such that 
hash(subString, power, modulo) == hashValue.

The hash value of a string 's' of length 'k' is computed using the following function
hash(s, p, m) =  (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1)  % m.

Where val(s[i]) represents the position of s[i] in the alphabet order 
from 'a' to 'z' (1 to 26).

A substring is a contiguous non-empty sequence of characters within a string.
Sample Test Cases:
Case=1
Input:
weekend
7
20
2
0
Output: ee
Explanation: The hash of "ee" can be computed to be hash("ee", 7, 20) = 
(5 * 1 + 5 * 7) mod 20 = 40 mod 20 = 0. 
"ee" is the first substring of length 2 with hashValue 0. Hence, we return "ee".

Case=2
Input: 
fbxzaad
31
100
3
32
Output: "fbx"
Explanation: The hash of "fbx" can be computed to be hash("fbx", 31, 100) = 
(6 * 1 + 2 * 31 + 24 * 312) mod 100 = 23132 mod 100 = 32. 
The hash of "bxz" can be computed to be hash("bxz", 31, 100) = 
(2 * 1 + 24 * 31 + 26 * 312) mod 100 = 25732 mod 100 = 32. 
"fbx" is the first substring of length 3 with hashValue 32. Hence, we return "fbx".
Note that "bxz" also has a hash of 32 but it appears later than "fbx".
 

Constraints:
1 <= k <= s.length <= 2 * 104
1 <= power, modulo <= 109
0 <= hashValue < modulo
s consists of lowercase English letters only.
The test cases are generated such that an answer always exists.
'''
# Please use this code segment for solving the above problem using Python
def val(c):
    return ord(c) - ord('a') + 1

def hash_substring(substring, power, modulo):
    h = 0
    for i, c in enumerate(substring):
        h = (h + val(c) * pow(power, i)) % modulo
        # print("h",h)
        # print("power",pow(power,i,modulo))
        # print(i,c)
    return h

def hashedStr(s, p, m, k, hashValue):
    for i in range(len(s) - k + 1):
        substring = s[i:i+k]
        if hash_substring(substring, p, m) == hashValue:
            return substring
s = input()
p = int(input())
m = int(input())
k = int(input())
hashVal = int(input())
print(hashedStr(s, p, m, k, hashVal))