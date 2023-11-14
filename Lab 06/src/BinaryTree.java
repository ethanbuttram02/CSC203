import java.util.LinkedList; 

public class BinaryTree { 
    private Node root; 
    private LinkedList<Integer> path; 
 
    public BinaryTree(int[] values)     { 
       this.root = buildTree(values, 0, values.length - 1); 
       this.path = new LinkedList<>(); 
    } 
    
    public LinkedList<Integer> getPath() { return path; } 
    
    // Bulids tree by adding middle element, then making recursive 
    // calls on the left and right halves of the array 
    private Node buildTree(int[] values, int low, int high)     { 
      if ( low <= high){
         int mid = (low+high)/2;
         return new Node(values[mid], buildTree(values, low, mid-1), buildTree(values, mid+1, high));
      }
      return null;
   }
   
   public boolean find(int searchVal){
      path.clear();
      return find(searchVal, root);
   }
   // Returns true if the searchVal is in the tree 
   // Also builds the path leading to the searchVal 
   private boolean find(int searchVal, Node node){
      boolean found;
      if ( node == null)
         found = false;
      else if (node.value == searchVal)
         found = true;
      else
         found = find ( searchVal, node.left) || find ( searchVal, node.right);
      if (found)
         path.add(0, node.value);
      return found;
   }
 
    // Inner class. Private data can be accessed by outer class 
    private class Node  { 
       private int value; 
       private Node left, right; 
       
       public Node(int value, Node left, Node right)  { 
       this.value = value; 
       this.left = left; 
       this.right = right; 
       } 
    } 
} 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 