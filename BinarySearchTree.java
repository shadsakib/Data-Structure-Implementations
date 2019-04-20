package binarysearchtree;

/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */

public class BinarySearchTree 
{
    static Node root;
    
    BinarySearchTree()
    {
     BinarySearchTree.root = null;     
    }
    
    void insert(int data)
    {
      Node n = new Node(data);
      
      if(root == null){
          root = n;
          return;
      }
      
      Node parent = null;
      Node curr = root;
      
      while(curr != null)
      {
        parent = curr;
        
        if(curr.data > data){
          curr = curr.leftChild;
           
          if(curr == null){
            parent.leftChild = n;
            return;
          }
        }
        else{ 
          curr = curr.rightChild;
          
          if(curr == null){
            parent.rightChild = n;
            return;
          }
        }
      }
         
    }
    
    void delete(int data)
    {
      Node parent = null;
      Node curr = root;
      boolean isLeftChild = false;
      
      while(curr.data != data)
      {
       parent = curr;
       
       if(curr.data > data){
         isLeftChild = true;
         curr = curr.leftChild;
       }
       else{
         isLeftChild = false;
         curr = curr.rightChild;
       }
       
       if( curr == null) 
           return;
      }
      
      if(curr.leftChild == null && curr.rightChild == null)
      {
           if(curr == root){
            root = null;
           }
           
           if(isLeftChild == true){
             parent.leftChild = null;
           }
           else{
             parent.rightChild = null;
           }
      }
      else if( curr.leftChild == null)
      {
        if(curr == root){
          root = curr.rightChild;
        }
        else if(isLeftChild == true){
          parent.leftChild = curr.rightChild;
        }
        else{
          parent.rightChild = curr.rightChild;
        }
      }
      else if (curr.rightChild == null)
      {
        if(curr == root){
         root = curr.leftChild;
        }
        else if(isLeftChild == true){
         parent.leftChild = curr.leftChild;
        }
        else{
         parent.rightChild = curr.leftChild;
        }
      }
      else if( curr.leftChild!= null && curr.rightChild!= null)
      {
         Node successor	 = getSuccessor(curr);
			if(curr==root){
				root = successor;
			}else if(isLeftChild == true){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}			
			successor.leftChild = curr.leftChild;
   
      }
      
    }
   
    void print(Node root)
    {
      if(root != null)
      {    
        print(root.leftChild);
        System.out.print(root.data+" ");
        print(root.rightChild);
      }
    }
       
    int findMaximumIterative()
    {
      Node curr = root;
      
      while(curr.rightChild != null)
      {
        curr = curr.rightChild;
      }
      
      return curr.data;
    }
    
    int findMinimumIterative()
    {
      Node curr = root;
      
      while(curr.leftChild != null)
      {
       curr = curr.leftChild;
      }
      
      return curr.data;
    }
    
    Node findMinimum(Node root)
    {
      if(root == null)
          return null;
      
      if(root.leftChild != null)
          return findMinimum(root.leftChild);
      
      return root;
    
    }
    
      Node findMaximum(Node root)
    {
      if(root == null)
          return null;
      
      if(root.rightChild != null)
        return findMaximum(root.rightChild);
      
      return root;
    }
      
      Node getSuccessor(Node n)
      {
        Node successor = null;
        Node successorParent = null;
        
        Node curr = n.rightChild;
        
        while(curr!= null)
        {
         successorParent = successor;
         successor = curr;
         curr = curr.leftChild;
        }
        
        if(successor!=n.rightChild)
        {
          successorParent.leftChild = successor.rightChild;
	   successor.rightChild = n.rightChild;
        }
      
        return successor;
      }
      
      

Node successor(Node x)
{       
    if( x.rightChild != null )
        return findMinimum(x.rightChild);
 
    Node successor = null;
 
    while (root != null)
    {
        if (x.data < root.data)
        {
            successor = root;
            root = root.leftChild;
        }
        else if (x.data > root.data)
            root = root.rightChild;
        else
           break;
    }
    return successor;
}


Node predecessor(Node n)
{
  if(n.leftChild != null)
      return findMaximum(n.leftChild);
  
  Node predecessor = null;
  
  while( root!= null)
  {
    if(n.data > root.data)
    {
      predecessor = root;
      root = root.rightChild;
    }
    else if(n.data < root.data)
      root = root.leftChild;
    else 
      break;

  }
  
  return predecessor;
}

    
    static void search(int data)
    {
      Node n = root;
            
      while(n!= null)
      {
         if(n.data == data)
            break;
         else if(n.data>data)
             n = n.leftChild;
         else
             n = n.rightChild;
      }
      
      if(n == null)
          System.out.println("Not Found");
      else
          System.out.println("Found");      
    }
    
    /* Sequence of nodes from node a to node b */
    static void printSequence(int a, int b)
    {
      Node startingNode = search1(a);
      
      Node n = startingNode;
      while(n!= null)
      {
       System.out.print(n.data + " ");
        if(n.data == b)
            break;
        else if (n.data > b)
            n = n.leftChild;
        else
            n = n.rightChild;
      }
      
    }
    
     void levelOrder(Node root)
   {
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
    {
        printGivenLevel(root, i);
        System.out.println();
    }
   }
    
   void printGivenLevel(Node root, int level)
   {
    if (root == null)
        return;
    if (level == 1)
        System.out.println(root.data+" ");
    else if (level > 1)
    {
        printGivenLevel(root.leftChild, level-1);
        printGivenLevel(root.rightChild, level-1);
    }
   }
    
     static Node search1(int data)
    {
      Node n = root;
            
      while(n!= null)
      {
         if(n.data == data)
            return n;
         else if(n.data>data)
             n = n.leftChild;
         else
             n = n.rightChild;
      }
      
      return null;
    }
      
        
    int height(Node root)
    {
      if(root== null)
          return 0;
      else
         return 1+Integer.max(height(root.leftChild), height(root.rightChild));
    }
    
    
  
      
    
    public static void main(String[] args) 
    {
      BinarySearchTree bst = new BinarySearchTree();
      
      bst.insert(20);
      bst.insert(40);
      bst.insert(11);
      bst.insert(30);
      bst.insert(50);
      
      System.out.println("Sequence: ");  printSequence(20, 50);
      
      //bst.print(root);
      
      //bst.delete(40);
      
      System.out.println();
      
      bst.print(root);
      
      System.out.println();
      
      System.out.println(bst.height(root));
      
      bst.search(30);
      
      System.out.println(bst.predecessor(root.rightChild).data);
    }
    
}



class Node
{
 int data;
 Node leftChild;
 Node rightChild;
 
 Node(int data)
 {
  this.data = data;
 }
}
