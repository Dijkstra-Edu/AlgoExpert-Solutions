package Stacks;

import java.util.*;

class Program {

  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
    Stack<Integer> stk = new Stack<Integer>();
    int ans[] = new int[array.length];
    Arrays.fill(ans, -1);
    int len = array.length;

    for(int i=0; i<len*2; i++) {
      int id = i%(len);
      while(!stk.isEmpty() && array[id]>array[stk.peek()]) {
        ans[stk.pop()] = array[id];
      }
      stk.push(id);
    }
    return ans;
  }
}

