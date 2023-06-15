import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> ans = new ArrayList<Integer>();
    dfs(root, ans, 0);
    return ans;
  }

  public static void dfs(BinaryTree root, List<Integer> ans, int sum) {
    if(root.left == null && root.right == null) {
      ans.add(sum + root.value);
      return;
    }
    sum += root.value;
    if(root.left != null) dfs(root.left, ans, sum);
    if(root.right != null) dfs(root.right, ans, sum);
  }
}
