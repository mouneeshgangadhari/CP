/*
 * Cliff Shaw is working on the singly linked list.
He is given a list of boxes arranged as singly linked list,
where each box is printed a positive number on it.

Your task is to help Mr Cliff to find the given list is equivalent to 
the reverse of it or not. If yes, print "true", otherwise print "false"

Input Format:
-------------
Line-1: space separated integers, boxes as list.

Output Format:
--------------
Print a boolean a value.


Sample Input-1:
---------------
3 6 2 6 3

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 6 2 3 6

Sample Output-2:
----------------
false


 */
import java.util.*;
class Node{    
	int data;    
	Node next;    
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
    //Function to check whether the list is palindrome.
    Node getmid (Node head)
    {
        Node slow =  head ;  
        Node fast =  head.next ;   
        while(fast !=  null && fast.next != null )
        {
            fast =  fast.next.next ;  
            slow =  slow.next ;  
        }
        return slow ;  
    }
    Node reverse(Node head){
        Node curr  =  head ;  
        Node prev =  null  ;  
        Node next =  null ;          
        while(curr !=  null)
        {
            next =  curr.next ;  
            curr.next  =  prev  ; 
            prev = curr ;  
            curr =  next ;  
        }
        return prev ;  
    }     
    boolean isPalindrome(Node head) 
    {
        //Write your code here
        if (head == null || head.next == null)
            return true;

        Node mid = getmid(head);
        Node secondHalf = reverse(mid.next);
        mid.next = null; // break the link between first half and second half

        Node p1 = head;
        Node p2 = secondHalf;

        while (p1 != null && p2 != null)
        {
            if (p1.data != p2.data)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
        
    }
}
class PalindromeList {    
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
    public static void main(String[] args) {    
        Scanner sc=new Scanner(System.in);
        PalindromeList list = new PalindromeList();       
        String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
    }    
}  


