import java.util.ArrayList;
import java.util.Collection;
import java.lang.Math;

public class MaxHeap
{
   private ArrayList<Student> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }
      
   public MaxHeap(Collection<Student> collection)
   {
      students = new ArrayList<Student>(collection);
      Student temp;
      for(int i = 0; i < size(); i++){
         students.get(i).UpdatePos(i);
      }
      for(int i = size()/2 - 1; i >= 0; i--)
      {
         temp = students.get(i);
         maxHeapify(temp, i);
      }
   }
   
   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public Student extractMax()
   {
      Student value = getMax();
      Student temp = students.get(size()-1);
      students.set(0,students.get(size()-1));
      temp.UpdatePos(0);
      students.remove(size()-1);
      maxHeapify(temp, 0);
      return value;
   }
    
   public int size()
   {
      return students.size();
   }
   
   public void insert(Student elt)
   {
      //Please write me.  I should add the given student into the heap,
	  //following the insert algorithm from the videos.

      int temp = size();
      students.add(elt);
      elt.UpdatePos(size() - 1);
      //(function)
      SwapUp(elt, temp);
   }
   
   public void addGrade(Student elt, double gradePointsPerUnit, int units)
   {
      //Please write me.  I should change the student's gpa (using a method
	  //from the student class), and then adjust the heap as needed using
	  //the changeKey algorithm from the videos.
      //hold the position of the changed student
      int temp = elt.GetPos();
      elt.addGrade(gradePointsPerUnit, units);
      //when it is not in root's position nad it's parent is larger, go up
      SwapUp(elt, temp);
      //when one if it's left or right child is greater, swap down
      maxHeapify(elt, temp);
   }

   private void SwapUp(Student elt, int index){
      while(students.get(index).compareTo(students.get(parent(index))) > 0){
         swap(index, parent(index));
         index = parent(index);
      }
   }

   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   private void swap(int from, int to)
   {
      Student val = students.get(from);
      Student val1 = students.get(to);
      students.set(from,  students.get(to));
      students.set(to,  val);
      val.UpdatePos(to);
      val1.UpdatePos(from);
   }

   private void maxHeapify(Student elt, int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      //elt.UpdatePos(largest);
      if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(elt, largest);
      }
   }   
}