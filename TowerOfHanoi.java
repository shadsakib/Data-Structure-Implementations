package tower.of.hanoi;
import java.util.Scanner;
/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */
public class TowerOfHanoi {

      public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int n = sc.nextInt();
        recursiveHanoi(n, "A", "B", "C");
    }
    
    static void recursiveHanoi(int n, String i, String j, String k)
    {
       if(n==1)
          System.out.println("Moved Disk 1 from "+i+" to "+k);
       else
       {
         recursiveHanoi(n-1, i, k, j);
         System.out.println("Moved Disk "+n+" from "+i+" to "+k);
         recursiveHanoi(n-1, j, i, k);
       }
    }
    
}
