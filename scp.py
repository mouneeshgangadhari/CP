'''
Given a binary search tree (BST), find the smallest common parent (scp) node of two given nodes in the BST.

The smallest common parent is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
case=1
input=6 2 8 0 4 7 9 3 5
2
4
output=2

case=2
input=6 2 8 0 4 7 9 3 5
2
8
output=6
'''


class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
def scp(root, p, q):
	if p < root.key and q < root.key:
		return scp(root.left, p, q)
	elif p > root.key and q > root.key:
		return scp(root.right, p, q)
	else:
		return root
def insert(root, key):
    if root is None:
        return Node(key)
    else:
        if key < root.key:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    return root

if __name__ == "__main__":
	root = None
	vals = [int(i) for i in input().split()]
	for key in vals:
		root = insert(root, key)
	p=int(input())
	q=int(input())
	res=scp(root,p,q)
	print(res.key)