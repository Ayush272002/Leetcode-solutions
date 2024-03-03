import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    public boolean isEvenOddTree(TreeNode root)
    {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty())
        {
            int sz = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < sz; i++)
            {
                if(level%2 ==0)
                {
                    TreeNode temp = q.poll();
                    if(temp != null)
                    {
                        int val = temp.val;
                        if(val%2 != 0)
                        {
                            if(currLevel.isEmpty()) currLevel.add(val);
                            else
                            {
                                if(currLevel.getLast() < val)
                                    currLevel.add(val);
                                else return false;
                            }
                            if(temp.left != null) q.add(temp.left);
                            if(temp.right != null) q.add(temp.right);
                        }
                        else return false;
                    }
                }
                else //odd level
                {
                    TreeNode temp = q.poll();
                    if(temp != null)
                    {
                        int val = temp.val;
                        if(val%2 == 0)
                        {
                            if(currLevel.isEmpty()) currLevel.add(val);
                            else
                            {
                                if(currLevel.getLast() > val)
                                    currLevel.add(val);
                                else return false;
                            }
                            if(temp.left != null) q.add(temp.left);
                            if(temp.right != null) q.add(temp.right);
                        }
                        else return false;
                    }
                }
            }
            level++;
        }

        return true;
    }
}