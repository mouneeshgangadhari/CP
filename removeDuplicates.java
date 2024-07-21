/*Mr Ram is working in a factory, that factory manufactures items which are 
having unique code printed on each item. and machine prints unique codes on items 
in non-decreasing order, some times because of timing problem machine prints 
same number on items.Job of Ram is to remove such duplicates from the stock.

And order of the items should not get distrubed after removal. 
Can you help ram to do this job easily with the help of a program. 

input format : an integer n
               n number of integer in non-decreasing order
output format : integers in non decreasing order without duplicates


Example 1:
input=10
0 0 1 1 2 2 3 3 4 5
output=0 1 2 3 4 5

Example 2:
input=8
1 2 3 4 5 6 7 8
output=1 2 3 4 5 6 7 8*/

import java.util.*;
class Node
{
    int data;
    Node next;
    public Node(int d)
    {
        data = d;
        next = null;
    }
}

class Solution
{
    public Node removeDup(Node head)
    {
        Node t1 = head;
        Node t2 = head.next;
        while(t2.next!=null)
        {
            if(t1.data==t2.data)
            {
                t2 = t2.next;
            }
            else
            {
                t1.next = t2;
                t1 = t2;
                t2=t2.next;
            }
        }
        if(t1!=null && t2!=null && t1.data==t2.data){
            t1.next=null;
        }
        return head;
    }
}

class removeDuplicates
{
    public Node head = null;
    public Node tail = null;
    public void addNode(int d)
    {
        Node nw = new Node(d);
        if(head==null)
        {
            head = nw;
            tail = nw;
        }
        else{
            tail.next = nw;
            tail = nw;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        removeDuplicates list = new removeDuplicates();
        for(int i=0;i<arr.length;i++)
        {
            list.addNode(arr[i]);
        }
        Solution s = new Solution();
        Node h = s.removeDup(list.head);
        while(h!=null)
        {
            System.out.print(h.data+" ");
            h = h.next;
        }
    }
}