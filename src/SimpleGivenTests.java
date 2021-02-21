import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;


public class SimpleGivenTests
{
   @Test
   public void oneStudent()
   {
      MaxHeap heap = new MaxHeap(10);
      heap.insert(new Student("Susan", 3.5, 60));
      assertEquals(3.5, heap.extractMax().gpa(), .000001);
      assertEquals(0, heap.size());
   }

   @Test
   public void aInsertAFewStudents()
   {
      MaxHeap heap = new MaxHeap(10);
      heap.insert(new Student("Susan", 3.5, 60));
      heap.insert(new Student("Ben", 3.4, 70));
      heap.insert(new Student("Reed", 4.0, 120));
      heap.insert(new Student("Johnny", 1.2, 50));
      assertEquals(4.0, heap.extractMax().gpa(), .000001);
      assertEquals(3.5, heap.extractMax().gpa(), .000001);
      heap.insert(new Student("Billy", 2.7, 20));
      assertEquals(3.4, heap.extractMax().gpa(), .000001);
      assertEquals(2.7, heap.extractMax().gpa(), .000001);
      assertEquals(1.2, heap.extractMax().gpa(), .000001);

       ArrayList<Student> myarry = new ArrayList<>(10);
       myarry.add(new Student("A", 25, 60));
       myarry.add(new Student("B", 22, 60));
       myarry.add(new Student("C", 24, 60));
       myarry.add(new Student("D", 28, 60));
       myarry.add(new Student("E", 26, 60));
       myarry.add(new Student("F", 29, 60));
       myarry.add(new Student("G", 21, 60));
       myarry.add(new Student("H", 23, 60));
       myarry.add(new Student("I", 27, 60));
       MaxHeap heap1 = new MaxHeap(myarry);
      assertEquals(29, heap1.extractMax().gpa(), .000001);
      assertEquals(28, heap1.extractMax().gpa(), .000001);
      assertEquals(27, heap1.extractMax().gpa(), .000001);
      assertEquals(26, heap1.extractMax().gpa(), .000001);
      assertEquals(25, heap1.extractMax().gpa(), .000001);
      assertEquals(24, heap1.extractMax().gpa(), .000001);
      assertEquals(23, heap1.extractMax().gpa(), .000001);
      assertEquals(22, heap1.extractMax().gpa(), .000001);
      assertEquals(21, heap1.extractMax().gpa(), .000001);
   }

   @Test
   public void exceptionTest()
   {
      MaxHeap heap = new MaxHeap(10);
      heap.insert(new Student("Ben", 3.4, 70));
      assertEquals(3.4, heap.extractMax().gpa(), .000001);
      try {
    	  heap.extractMax();
    	  fail("You shouldn't reach this line, an IndexOutOfBoundsException should have been thrown.");
      } catch (IndexOutOfBoundsException except) {
    	  assertEquals(except.getMessage(), "No maximum value:  the heap is empty.");
      }

   }
   
   @Test
   public void changeKeyTest()
   {
	   MaxHeap heap = new MaxHeap(10);
	   Student susan = new Student("Susan", 3, 6);
	   Student ben = new Student("Ben", 2.4, 10);
	   Student reed = new Student("Reed", 3.3, 3);
	   Student johnny = new Student("Johnny", 1, 4);
	   heap.insert(susan);
	   heap.insert(ben);
	   heap.insert(johnny);
	   heap.insert(reed);
	   assertEquals(reed, heap.getMax());
	   heap.addGrade(susan, 4, 3);  //should give her a 3.333333333 gpa
	   assertEquals(susan, heap.getMax());
	   assertEquals(3.33333333, heap.extractMax().gpa(), .000001);
	   heap.addGrade(reed, .7, 3);  //should give him a 2.0
	   heap.addGrade(johnny,  4,  4);  //should give him a 2.5
	   assertEquals(2.5, heap.extractMax().gpa(), .000001);
	   assertEquals(2.4, heap.extractMax().gpa(), .000001);
	   assertEquals(2.0, heap.extractMax().gpa(), .000001);
	   //test by my own
       heap.insert(new Student("A", 25, 1));
       heap.insert(new Student("B", 22, 1));
       heap.insert(new Student("C", 24, 1));
       heap.insert(new Student("D", 28, 1));
       heap.insert(new Student("E", 26, 1));
       heap.insert(new Student("F", 29, 1));
       heap.insert(new Student("G", 21, 1));
       heap.insert(new Student("H", 23, 1));
       heap.insert(new Student("I", 27, 1));
       Student s = new Student("Susan", 3, 6);
       Student j = new Student("Susan");
       heap.insert(s);
       heap.addGrade(s, 300, 1);
       assertEquals((double)318/7, heap.extractMax().gpa(), .0000001);
   }
   
}