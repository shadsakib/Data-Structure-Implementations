package hashing;

public class Hashing {
    
    static int arr[] = new int[30];
    static int collisions = 0;
    static int collisionIndex;
    static int[] collidedElements = new int[30];
    static int i = 0;

    public static void main(String[] args) 
    {
      Hashing h = new Hashing();
      
      h.insertData(20);
      h.insertData(30);
      h.insertData(12);
      h.insertData(300);
      h.insertData(3000);
      h.insertData(200);
      h.printArray();
      
      System.out.println();
      System.out.println(h.find(12));
      
      int sum=0;    
      int index = 0;
      
           sum+= arr[index];
      
      for(int i: h.collidedElements)
      {    
        if( i%30 == 0) sum += i;
      }
      
      System.out.println(sum);
    }
    
    Hashing()
    {
      for(int i=0; i<arr.length; i++)
          arr[i] = -1;
    }
    
    int hashFunction(int data)
    {
      return data%30;
    }
    
    void insertData(int data)
    { 
     if(arr[hashFunction(data)] == -1){   
      arr[hashFunction(data)] = data;
     }
     else{
      collisions++;
      collisionIndex = hashFunction(data);
      collidedElements[i++] = data;
     }
    }
    
    void printArray()
    {
      for(int x: arr)
          System.out.print(x+" ");
    }
    
    int find(int data)
    {
      int index = hashFunction(data);
      
      if(arr[index] == data){
       return index;
      }
      return -1;
    }
    
    
}



