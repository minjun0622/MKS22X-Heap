import java.util.*;
public class MyHeap {

  //We discussed these 2 methods already:
  /* - size  is the number of elements in the data array.
   - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
   - precondition: index is between 0 and size-1 inclusive
   - precondition: size is between 0 and data.length-1 inclusive.
   */
private static void pushDown(int[] data, int size, int index) {
  int right = 2 * index + 2;
  int left = 2 * index + 1;
  int max;
    if (right < size) {
      if (data[right] > data[left])
        max = right;
      else max = left;
    }
    else max = left;
    while(max < size && data[max] > data[index]) {
      swap(data, index, max);
      index = max;
      left = 2 * index + 1;
      right = 2 * index + 2;
      if (right < size) {
        if (data[right] > data[left])
          max = right;
        else max = left;
      }
      else max = left;
    }
  }
  /*- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  - precondition: index is between 0 and data.length-1 inclusive.
  */
  //if there's an element that is greater than the parent.
private static void pushUp(int[] data, int index){
  int parent = (index - 1) / 2;
  if (index > 0){
      while (data[index] > data[parent]) {
    swap(data, index, parent);
       index = parent;
       parent = (index-1)/2;
     }
   }
 }


//We will discuss this today:
  //- convert the array into a valid heap. [ should be O(n) ]
public static void heapify(int[] data){
  for (int i = data.length - 1; i >= 0; i--) {
    pushDown(data, data.length, i);
    }
  }

public static void heapsort(int[] data){
  heapify(data);
  int size = data.length;
  for (int i = size - 1; i >= 0; i--){
    swap(data, 0, i);
    size--;
    pushDown(data, size, 0);
  }
}

  //swap method to help with sorting.
  public static void swap(int[] data, int swap, int swapper) {
    int temp;
    temp = data[swap];
    data[swap] = data[swapper];
    data[swapper] = temp;
  }

  public static void main(String[]args){
   System.out.println("Size\t\tMax Value\theapsort/builtin ratio ");
   int[]MAX_LIST = {1000000000,500,10};
   for(int MAX : MAX_LIST){
     for(int size = 31250; size < 2000001; size*=2){
       long qtime=0;
       long btime=0;
       //average of 5 sorts.
       for(int trial = 0 ; trial <=5; trial++){
         int []data1 = new int[size];
         int []data2 = new int[size];
         for(int i = 0; i < data1.length; i++){
           data1[i] = (int)(Math.random()*MAX);
           data2[i] = data1[i];
         }
         long t1,t2;
         t1 = System.currentTimeMillis();
         MyHeap.heapsort(data2);
         t2 = System.currentTimeMillis();
         qtime += t2 - t1;
         t1 = System.currentTimeMillis();
         Arrays.sort(data1);
         t2 = System.currentTimeMillis();
         btime+= t2 - t1;
         if(!Arrays.equals(data1,data2)){
           System.out.println("FAIL TO SORT!");
           System.exit(0);
         }
       }
       System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
     }
     System.out.println();
   }
   System.out.println();
   int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
   HeapPrinter.print(arr);
   System.out.println();
 }

}
