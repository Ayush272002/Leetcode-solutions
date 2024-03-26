class NumArray
{
    private class TreeNode
    {
        int data;
        TreeNode left,right;
        int startInterval, endInterval;

        TreeNode(int startInterval, int endInterval)
        {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private TreeNode root;
    public NumArray(int[] nums)
    {
        this.root = build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] arr, int start, int end)
    {
        if(start == end)
        {
            TreeNode leaf = new TreeNode(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        TreeNode node = new TreeNode(start,end);

        int mid = start + (end-start)/2;
        node.left = build(arr,start,mid);
        node.right = build(arr,mid+1,end);


        node.data = node.left.data + node.right.data;
        return node;
    }
    public void update(int index, int val)
    {
        this.root.data = update(this.root,index,val);
    }

    private int update(TreeNode node, int index, int val)
    {
        if(index >= node.startInterval && index <= node.endInterval)
        {
            if(index == node.startInterval && index == node.endInterval) node.data = val;
            else
            {
                int left = update(node.left,index,val);
                int right = update(node.right, index, val);
                node.data = left+right;
            }

            return node.data;
        }

        return node.data;
    }

    public int sumRange(int left, int right)
    {
        return query(this.root, left,right);
    }

    private int query(TreeNode node, int qsi, int qei)
    {
        if(node.startInterval >= qsi && node.endInterval <= qei) return node.data;
        else if(node.startInterval > qei || node.endInterval < qsi) return 0;
        else
        {
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */