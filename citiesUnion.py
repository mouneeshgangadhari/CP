'''
Input n which is number of cities.
Input n*n matrix cities with 0's and 1's where cities[i][j] = 1 if the ith city and the jth city are directly connected, and cities[i][j] = 0 otherwise.

If city 'i' is connected directly with city 'j', and city 'j' is connected directly with city 'k', then city 'i' is connected indirectly with city 'k'.

A Union is a group of directly or indirectly connected cities and no other cities outside of the group.

Find the total number of Unions.

Example 1:
input=3
1 1 0
1 1 0
0 0 1
output=2
Explanation:
	city1 is connected to city2
	city3 is not connected to any of the other
Example 2:
input=3
1 0 0
0 1 0
0 0 1
output=3
'''

class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        
        if not M: return 0
        s = len(M)
        seen = set()
        cnt = 0
        for i in range(s):
            if i not in seen:
                q = [i]
                while q:
                    p = q.pop(0)
                    if p not in seen:
                        seen.add(p)
                        q += [k for k,adj in enumerate(M[p]) if adj and (k not in seen)]
                cnt += 1
        
        return cnt

ob=Solution()
cities=[]
n=int(input())
for i in range(n):
	cities.append([int(x) for x in input().split()])
res=ob.findCircleNum(cities)
print(res)

'''
Test Cases:
case=1
input=4
1 0 1 0
0 1 1 0
1 1 1 0
0 0 0 1
output=2

case=2
input=5
1 0 0 0 0
0 1 0 0 0
0 0 1 0 0
0 0 0 1 0
0 0 0 0 1
output=5

case=3
input=5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
output=1

case=4
input=5
1 0 1 0 0
0 1 0 1 0
1 0 1 0 0
0 1 0 1 0
0 0 0 0 1
output=3

case=5
input=6
1 1 0 0 0 0
1 1 0 0 0 0
0 0 1 1 0 0
0 0 1 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
output=4
'''