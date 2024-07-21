import java.util.*;
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
class midelementinList
{
    public Node head=null;
    public Node tail=null;
    public  void addNode(int data) {    
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
    public int midElement(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.val;
    }
    public static void main(String[] args) 
    {    
        Scanner sc = new Scanner(System.in);
        midelementinList list = new midelementinList();       
        String list2[] = sc.nextLine().split(" "); 
        for (int i = 0; i < list2.length; i++)
            list.addNode(Integer.parseInt(list2[i]));
        System.out.println(list.midElement(list.head));
    }
}
