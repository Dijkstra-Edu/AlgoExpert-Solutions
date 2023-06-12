class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList middleNode(LinkedList linkedList) {
    LinkedList hare = linkedList;
    LinkedList turtle = linkedList;
    
    while(hare!=null) {
      hare = hare.next;
      if(hare!=null) {
         hare = hare.next;
         turtle = turtle.next;
      }
    }
    return turtle;
  }
}
