public class MyHeap {

  //We discussed these 2 methods already:
  /* - size  is the number of elements in the data array.
   - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
   - precondition: index is between 0 and size-1 inclusive
   - precondition: size is between 0 and data.length-1 inclusive.
   */
private static void pushDown(int[] data, int size, int index) {
  while (index < data.length){
    if (data[index] < data[2 * index + 1]) {
      swap(data[index], data[2 * index + 1]);
    }
    if (data[index] < data[2 * index + 2]){
      swap(data[index], data[2 * index + 2]);
    }
    index++;
  }
}
  /*- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  - precondition: index is between 0 and data.length-1 inclusive.
  */
  //if there's an element that is greater than the parent.
private static void pushUp(int[] data, int index){
  while (index < data.length) {
    if (data[index] < data[(index - 1) / 2]) {
      swap(data[index], data[(index - 1) / 2]);
    }
    index++;
  }
}


//We will discuss this today:
  //- convert the array into a valid heap. [ should be O(n) ]
public static void heapify(int[] data){
  for (int i = 0; i < data.length - 1; i++) {
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
  private void swap(int[], data int swap, int swapper) {
    int temp;
    temp = data[swap];
    data[swap] = data[swapper];
    data[swapper] = temp;
  }

  public static void main(String[] args) {
    int[] data = {12, 14, 41, 1, 4, 5};


  }
}
