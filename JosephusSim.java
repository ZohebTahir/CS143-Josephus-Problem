import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      circle = null;
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         while(fileName.hasNext()) {
            add(fileName.next());    
         }
         // make the ring circular by attaching last node's next to front
         PersonNode current = circle;
         while(current.next != null) {
            current = current.next;
         }
         current = circle.next; 
         // remember the last node as the one in front of the next to get eliminated
         
         // generate, print, and save the random elimination count

      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
      circle = new PersonNode(val, circle);
      
   }
   
   public void eliminate() {
      // count to the elimination count
      
      // print who will be eliminated
      
      // eliminate the person and update "front" of the circle and size

   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
       if(size == 1) {
         return true;
      } 
      return false;
   }
   
   public String toString() {
      String result = "";
      // if there's only one person left, print them as the last survivor
        if(size == 1) {
         return circle.name;
      } 
      // print the remaining survivors (watch out for infinite loop since list is circular)
      else {
         while(current.next != front) {
            result += current.data;
            current = current.next;
         } 
      }
        return result;  

   }

}