/* 
In a school students are formed a line with hand in hand on the day of 
independenceday.By observing the fitness of students physical director of the 
school is removing students who are week from back side of the  line.  
After student is removed from the line order of line should not get distrubed. 
Your task is to write a program which demonstrate this scenario. 
you will be given the head of a line, remove the nth student from the end of the 
line and print the line after removal.

input format : space seperated integers
               an integer 
output format : space seperated integers

Example:
case =1
input= 1 2 3 4 5
2
output=1 2 3 5
case =2
input=5 1 6 2 7 4 8 9
4
output= 5 1 6 2 4 8 9

constraints :
1.n <= length of the linked list

*/
//Use following code segment and write your logic
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
    public Node removeNthFromEnd(Node head, int n) 
    {
         //WRITE YOUR CODE HERE
         Node t1 = head;
         Node t2 = head;
         for(int i=0;i<n;i++)
         {
             if(t2.next==null){
                 head = head.next;
                 return head;
             }
             t2 = t2.next;
         }
         while(t2.next!=null)
         {
             t1 = t1.next;
             t2 = t2.next;
         }
         Node curr = t1.next;
         t1.next = curr.next;
         return head;
    }
}
class removeNthNode {    
    //WRITE YOUR CODE HERE TO ADD NODE       
    public Node head = null;
    public Node tail = null;
    public void addNode(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public static void main(String[] args) 
    {    
        Scanner sc = new Scanner(System.in);
        removeNthNode list = new removeNthNode();       
        String list2[] = sc.nextLine().split(" "); 
        for (int i = 0; i < list2.length; i++)
            list.addNode(Integer.parseInt(list2[i]));
		int n =sc.nextInt();
     
        Solution sl = new Solution();
        Node temp = sl.removeNthFromEnd(list.head,n);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }    
}  
