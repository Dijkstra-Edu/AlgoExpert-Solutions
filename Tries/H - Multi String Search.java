import java.util.*;

class Program {
    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<Character, TrieNode>();
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        TrieNode root = new TrieNode();

        for (int i = 0; i < bigString.length(); i++) {
            String temp = bigString.substring(i);
            TrieNode curr = root;
            for (char ch : temp.toCharArray()) {
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new TrieNode());
                }
                curr = curr.child.get(ch);
            }
        }

        ArrayList<Boolean> ans = new ArrayList<Boolean>();

        for (String s : smallStrings) {
            TrieNode cur = root;
            int flag = 0;
            for (char ch : s.toCharArray()) {
                if (!cur.child.containsKey(ch)) {
                    ans.add(false);
                    flag++;
                    break;
                }
                cur = cur.child.get(ch);
            }
            if(flag == 0) ans.add(true);
        }

        return ans;
    }
}
