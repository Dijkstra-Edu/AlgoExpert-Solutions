
import java.util.*;

class Program {

    public static int nodeDepths(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        if (root == null)
            return 0;
        int ans = 0;
        int level = -1;
        queue.offer(root); // queue.add(root) - offer returns false if unsuccessful
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            level++;
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                queue.poll();
                //System.out.println(queue + " " + level);
                ans += level;
            }
        }
        return ans;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
