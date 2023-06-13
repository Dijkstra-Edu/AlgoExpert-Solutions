
class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList fast = head;
        LinkedList slow = head;     

        for(int i = 1; i <= k; ++i) {
          if(fast.next==null) break;
            fast = fast.next;
        }
    
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
