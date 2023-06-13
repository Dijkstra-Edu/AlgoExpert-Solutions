package Reverse a LinkedList;

import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
    LinkedList current = head;
    LinkedList prev = null;

    while(current != null) {
      LinkedList temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

