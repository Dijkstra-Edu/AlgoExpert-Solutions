class Program {
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
    LinkedList singlePointer = head;

    while(!singlePointer.visited) {
      singlePointer.visited = true;
      singlePointer = singlePointer.next;
    }
    return singlePointer;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;
    boolean visited = false; //Add a visited varible

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
