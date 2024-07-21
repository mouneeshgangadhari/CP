/*
given a singly LinkedList, find its middle element.
For example, if our input LinkedList is 1->2->3->4->5,
then the output should be 3.

Example 1:
input = 1 2 3 4 5 6 7 8 9
output= 5

Example 2:
input=20 50 60 70 80 90 100 200 110 120 130
output=90

 */

import java.util.*;
class Node
{
    int data;
    Node next;
    public Node(int d){
        data = d;
        next=null;
    }
}
//1 2 3 4 5 6 7 8 9
class Solution
{
    public int getMid(Node head)
    {
        Node t1 = head;
        Node t2 = head;
        while(t2.next!=null && t2.next.next!=null)
        {
            t2 = t2.next.next;
            t1 = t1.next;
        }
        return t1.data;
    }
}
class midElement
{
    public Node head = null;
    public Node tail = null;
    public void addNode(int d)
    {
        Node newNode = new Node(d);
        if(head==null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        midElement list = new midElement();
        String[] inp = sc.nextLine().split(" ");
        int n = inp.length;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            list.addNode(Integer.parseInt(inp[i]));
        }
        Solution s1 = new Solution();
        int r = s1.getMid(list.head);
        System.out.println(r);
    }
}