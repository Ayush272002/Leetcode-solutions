import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    TreeNode root;

    public CBTInserter(TreeNode root)
    {
        this.root = root;
    }

    private int insertIntoTree(TreeNode root, TreeNode val)
    {
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);

       while(!q.isEmpty())
       {
           int size = q.size();

           while(size > 0)
           {
               TreeNode front = q.poll();
               if(front!= null && front.left == null)
               {
                   front.left = val;
                   return front.val;
               }
               else if(front!= null)q.add(front.left);

               if(front!= null && front.right == null)
               {
                   front.right = val;
                   return front.val;
               }
               else if(front!= null) q.add(front.right);

               size--;
           }
       }

       return -1;
    }

    public int insert(int val)
    {
        TreeNode node = new TreeNode(val);

        return insertIntoTree(root , node);

    }

    public TreeNode get_root()
    {
        return root;
    }
}