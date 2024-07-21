/*
Given a singly LinkedList, Print Reverse of that list.

Example 1:
input = 1 2 3 4 5 6 7 8 9
output= 9 8 7 6 5 4 3 2 1

Example 2:
input=9 8 7 6 5 4 3 2 1
output=1 2 3 4 5 6 7 8 9


Use this code segment and write required Logic.
*/
import java.util.*;
class Node {    
    int data;    
    Node next;    
    public Node(int data) {    
        this.data = data;    
        this.next = null;    
    }    
}    
class Solution {
    Node reverse(Node head) 
    {
         Node temp = head;
         Node prev = null;
         Node next = temp.next;
         while(next!=null)
         {
             next=temp.next;
             temp.next = prev;
             prev=temp;
             temp=next;
         }
         return prev;
    }     
}
class ListReverse 
{    
    public Node head = null;    
    public Node tail = null;         
    public void addNode(int data) {    
        Node newNode = new Node(data);    
        if(head == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
           tail.next = newNode;    
            tail = newNode;    
        }    
    }       
     //WRITE YOUR CODE HERE   
    public static void main(String[] args) 
    {    
        Scanner sc = new Scanner(System.in);
        ListReverse list = new ListReverse();       
        String list2[] = sc.nextLine().split(" "); 
        for (int i = 0; i < list2.length; i++)
            list.addNode(Integer.parseInt(list2[i]));
     
        Solution sl = new Solution();
        Node temp = sl.reverse(list.head);
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }    
}

