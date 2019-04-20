package separatechaininghashing;

import java.util.LinkedList;

/**
 *
 * @author Shadman Sakib
 * Ahsanullah University of Science and Technology
 */


class SeparateChaining{
	
	LinkedList<String> indexList[];
	
	SeparateChaining(){
		
		indexList = new LinkedList[32];
		
		for(int i = 0; i<32; i++) {
			indexList[i] = new LinkedList<String>();
		}
		
	}
	
	public int findIndex(String s) {
		char ch[] = s.toCharArray();
		int XORresult = 0;
		for(int i = 0 ; i< ch.length; i++) {
			XORresult ^= ch[i]-'A'+1;
		}
		return XORresult%32;
	}
	
	public void insert(String s) {
		
		if(find(s) == false) {
			
			int index = findIndex(s);
			
			indexList[index].add(s);
			
		}
		
	}
	
	public boolean find(String s) {
		
		boolean found = false;
		
		int indextoSearch = findIndex(s);
			
		if(indexList[indextoSearch].contains(s)) {
			found = true;
		}
		
		return found;
	}
	
	
}

public class SeparateChainingHashing {

   	public static void main(String args[]) {
		String HashInput[] = {"A", "THE", "IN", "AS", "FOR", "OF","I", "NOT", "AND", "IS"};
				
		
		SeparateChaining sc = new SeparateChaining();
		
		for(String x: HashInput) {
			
			sc.insert(x);
			
		}
		
		System.out.println(sc.find("THE"));
                System.out.println(sc.find("ISS"));
		
	}
    
}
