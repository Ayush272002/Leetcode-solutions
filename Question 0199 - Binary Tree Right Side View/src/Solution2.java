import java.util.*;
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        Map<Integer, Integer> rightNode = new TreeMap<>();
        Queue<MyPair> q = new LinkedList<>();

        q.add(new MyPair(root,0));

        while(!q.isEmpty())
        {
            MyPair temp = q.poll();
            TreeNode right = temp.node;
            int distance = temp.position;

            rightNode.put(distance, right.val);

            if(right.left != null)
                q.add(new MyPair(right.left, distance+1));

            if(right.right != null)
                q.add(new MyPair(right.right, distance+1));
        }

        for(int key : rightNode.keySet())
            ans.add(rightNode.get(key));

        return ans;
    }
}