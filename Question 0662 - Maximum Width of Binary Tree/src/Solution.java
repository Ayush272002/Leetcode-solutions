import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Trio {
        TreeNode root;
        int num;
        int level;

        Trio(TreeNode root, int num, int level) {
            this.root = root;
            this.num = num;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Trio> q = new LinkedList<>();

        int prevLevel = 0, prevNum = 1;

        q.add(new Trio(root, 1, 0));

        while (!q.isEmpty()) {
            Trio temp = q.poll();

            if (temp.level > prevLevel) {
                prevLevel = temp.level;
                prevNum = temp.num;
            }

            ans = Math.max(ans, temp.num - prevNum + 1);

            if (temp.root.left != null)
                q.add(new Trio(temp.root.left, 2 * temp.num, temp.level + 1));

            if (temp.root.right != null)
                q.add(new Trio(temp.root.right, 2 * temp.num + 1, temp.level + 1));
        }

        return ans;
    }
}