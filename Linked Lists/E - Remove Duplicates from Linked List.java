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

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    LinkedList temp = linkedList;
    while(temp.next!=null) {
      if(temp.value == temp.next.value) {
        temp.next = temp.next.next;
      }
      else {
        temp = temp.next;
      }
    }
    return linkedList; //This is VERY IMPORTANT
  }
}
