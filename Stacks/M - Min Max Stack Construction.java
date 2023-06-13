package Stacks;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
    private class Node {
    int val;
    int min;
    int max;
    Node next;

    Node(int val, int min, int max, Node next) {
      this.val = val;
      this.min = min;
      this.max = max;
      this.next = next;
    }
  }

    Node head;
    
    public int peek() {
      System.out.print("peek ");
      print(head);
      return head.val;
    }

    public void print(Node node) {
      Node temp = head;
      while(temp!=null) {
        System.out.print(temp.val+"->");
        temp = temp.next;
      }
      System.out.println(temp);
    }

    public int pop() {
      int ans = head.val;
      head = head.next;
      System.out.print("pop ");
      print(head);
      return ans;
    }

    public void push(Integer number) {
      if (head == null) 
            head = new Node(number, number, number, null);
        else 
            head = new Node(number, Math.min(head.min, number), Math.max(head.max,number), head);
    }

    public int getMin() {
      return head.min;
    }

    public int getMax() {
      return head.max;
    }
  }
}
