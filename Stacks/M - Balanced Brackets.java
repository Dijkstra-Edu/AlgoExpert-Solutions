package Stacks;

import java.util.Stack;

class Program {
  public static boolean balancedBrackets(String str) {
    Stack<Character> stack = new Stack<Character>();
	for (char c : str.toCharArray()) {
        if(Character.isAlphabetic(c) || Character.isDigit(c) || c=='%' || c=='&' || c=='@') continue;
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;

      //System.out.println(stack);
	}
	return stack.isEmpty();
  }
}
