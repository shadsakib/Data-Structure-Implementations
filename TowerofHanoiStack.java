package towerofhanoistack;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */

public class TowerofHanoiStack {

    public static void main(String[] args) 
    {
      int n; 
      Scanner sc = new Scanner(System.in);
     
      System.out.println("Enter number of disks: ");
      n = sc.nextInt();
      
      nonRecursiveHanoi(n, 1, 2, 3);
    }
    
    
    
    static void nonRecursiveHanoi(int n, int i, int j, int k)
    {
      Stack<Integer> s = new Stack();
      Stack<Integer> a = new Stack();
      Stack<Integer> b = new Stack();
      Stack<Integer> c = new Stack();
      
      s.push(n);
      a.push(i);
      b.push(j);
      c.push(k);
      
      while(!s.empty())
      {
       n = s.peek();
       i = a.peek();
       j = b.peek();
       k = c.peek();
       
       if(n==1)
       {
        System.out.println("Move disk "+n+" from "+i+"to pole "+k);
        s.pop();
        a.pop();
        b.pop();
        c.pop();
       }
       else
       {
        s.pop();
        a.pop();
        b.pop();
        c.pop();
        
        s.push(n-1);
        s.push(1);
        s.push(n-1);
        
        a.push(j);
        a.push(i);
        a.push(i);
       
        b.push(i);
        b.push(j);
        b.push(k);
        
        c.push(k);
        c.push(k);
        c.push(j);
       }
       
      }
    
    }
    
    
}
