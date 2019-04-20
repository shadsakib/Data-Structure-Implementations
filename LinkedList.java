package linkedlist;

/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */

class Node
{
  int data;
  Node link;
  
  Node(int data)
  {
   this.data = data;
  }
  
  Node(Node n)
  {
   if(n != null)
   {
     this.data = n.data;
     this.link = n.link;
   }    
  }
}

public class LinkedList 
{
  Node head;
  
  LinkedList()
  {
   head = null;
  }
  
  void insert(int data)        // Inserts data in sorted position
  {
   Node n = new Node(data);
    
   if(head == null || n.data < head.data)
   { 
     Node tempHead = null;  
     if(head != null) tempHead = new Node(head);
     
     head = new Node(n);
     
     head.link = tempHead;
   }
   else
   { 
     Node pred, p; 
     pred = head;
     p = head.link;
     
     while( p!= null && p.data < data)
     {
      pred = p;
      p = p.link;
     }
   
     n.link = pred.link;
     pred.link = n;
   
   }
  }
  
  void delete(int data)         // Deletes specific data
  {
   Node p = head;
   
   while( p.link!= null && p.link.data!=data)
   {
    p = p.link;
   }
   
   if(p.link != null)
     {
      p.link = p.link.link;
     }
  }
  
  void insertAtEnd(int data) 
  {
   Node n = new Node(data);   
   Node temp = head;
   
   while(temp.link != null)
   {
    temp = temp.link;
   }
    n.link = temp.link;
    temp.link = n;
  }
  
  void deleteAtEnd()     
  {
   Node temp = head;
   
   while(temp.link.link != null)
   {
     temp = temp.link;  
   }
    temp.link = temp.link.link;
  }
  
  void deleteAtFirst()       
  { 
    Node temp = head;
    head = head.link;
    temp.link = null;
  }
  
  void insertAtFirst(int data)   
  {
   Node temp = head;
   head = new Node(data);
   head.link = temp;
  }
   
  void print()
  {
  for(Node i = head; i!=null; i=i.link)
  {
   System.out.print(i.data+" ");
  }
  
  }
  
  void reversePrint(Node t)   // This prints the stack from top to bottom
  {
     if( t.link!= null)
      {
       reversePrint(t.link);
      }
     
     System.out.print(t.data+" ");
      
  }
  
  public static void main(String[] args) 
    {
     LinkedList l = new LinkedList();
     l.insert(22);
     l.insert(23);
     l.insert(10);
     l.insert(-20);
     l.insertAtFirst(300);
     l.print();
     l.insert(30);
     l.insert(0);
     l.insertAtEnd(-30);
     l.insertAtEnd(-50);
     l.insertAtEnd(44);
     l.deleteAtEnd();
     l.deleteAtEnd();
     l.deleteAtEnd();
     l.print();
     l.insertAtEnd(2);
     l.insertAtEnd(-330);
     l.deleteAtEnd();
     l.deleteAtEnd();
     l.reversePrint(l.head);
     l.delete(10);
     l.reversePrint(l.head);
     l.print();
    }
    
}
