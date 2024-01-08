import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<MyPair> q = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        q.add(new MyPair(root, 0, 0));

        while (!q.isEmpty()) {
            MyPair temp = q.poll();
            TreeNode temp_root = temp.node;
            int distance = temp.position;
            int depth = temp.depth;

            if (!map.containsKey(distance)) {
                map.put(distance, new TreeMap<>());
            }

            if (!map.get(distance).containsKey(depth)) {
                map.get(distance).put(depth, new ArrayList<>());
            }

            map.get(distance).get(depth).add(temp_root.val);

            //if left child of temp_root exists, pushing it in
            //the queue with the horizontal distance and depth.
            if (temp_root.left != null) q.add(new MyPair(temp_root.left, distance - 1, depth + 1));

            //if right child of temp_root exists, pushing it in
            //the queue with the horizontal distance and depth.
            if (temp_root.right != null) q.add(new MyPair(temp_root.right, distance + 1, depth + 1));
        }

        for (TreeMap<Integer, List<Integer>> colMap : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> values : colMap.values()) {
                Collections.sort(values);
                col.addAll(values);
            }
            ans.add(col);
        }

        return ans;
    }
}