package huffmancoding;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */


class Node
{
  char letter;
  int frequency;
  Node left;
  Node right;
  
  Node(char letter, int frequency){
      this.letter = letter;
      this.frequency = frequency;
  }
}


public class HuffmanCoding 
{    
    static char letters[] =  {'a', 'b', 'c', 'd', 'e', 'f'};
    static int frequency[] = {5, 9, 12, 13, 16, 45};
     
    public static void main(String[] args) 
    {
       Node root = buildHuffmanTree();
        
        generateCodes(root, "");
    }
    
    
    static Node buildHuffmanTree()
    {              
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
               return a.frequency - b.frequency;
            }
        });
      
        for(int i=0; i<letters.length; i++)
            pq.add(new Node(letters[i], frequency[i]));
        
        
        Node top = null;
        while(pq.size()>1){
            Node a = pq.poll();
            Node b = pq.poll();
            
            top = new Node('*', a.frequency+b.frequency);
            
            top.left = a;
            top.right = b;
            
            pq.add(top);
        }
        
        return top;
    }
    
    static void generateCodes(Node root, String code)
    {
        if(root.left!=null)      
            generateCodes(root.left, code+"0");
    
        if(root.right!=null)
            generateCodes(root.right, code+"1");
    
        if(root.left==null && root.right==null)
            System.out.println(root.letter + " : " +code);
    }

}


    


