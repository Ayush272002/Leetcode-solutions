import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution1
{
    public int findBottomLeftValue(TreeNode root)
    {
        if(root == null) return -1;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = q.poll();
                if(temp != null) currLevel.add(temp.val);
                if(temp != null && temp.left != null) q.add(temp.left);
                if(temp != null && temp.right != null) q.add(temp.right);
            }

            levelOrder.add(currLevel);
        }

        ArrayList<Integer> lastLevel = levelOrder.getLast();
        return lastLevel.getFirst();
    }
}