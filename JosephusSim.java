import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      circle = null;
      size = 0;
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         while(file.hasNext()) {
            add(file.next());
         }
         // make the ring circular by attaching last node's next to front
         PersonNode current = circle;
         while(current.next != null) {
            current = current.next;
         }
         current.next = circle;
         // remember the last node as the one in front of the next to get eliminated
         track = current;
         // generate, print, and save the random elimination count
         Random randGen = new Random();
         eliminationCount = randGen.nextInt(size / 2) + 1;
         System.out.println("Elimination count is " + eliminationCount);
         
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
      circle = new PersonNode(val, circle);
      size++;
   }
   
   public void eliminate() {
      // count to the elimination count
      for(int i = 1; i < eliminationCount; i++) {
         track = track.next;
      }
      // print who will be eliminated
      PersonNode remove = track.next;
      System.out.println(remove.name + " is eliminated");
      // eliminate the person and update "front" of the circle and size
      track.next = remove.next;
      circle = track.next;
      size--;
   }

   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      String result = "";
      // if there's only one person left, print them as the last survivor
      if(size == 1) {
         return circle.name;
      }
      // print the remaining survivors (watch out for infinite loop since list is circular)
      else {
         int count = 1;
         PersonNode current = circle;
         while(current.next != circle) {
            result += count + "-" + current.name + ", ";
            current = current.next;
            count++;
         } 
         result += count + "-" + current.name;
      }
      return result;        
   }

}