class Solution
{
    private void merge(int[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m+1, R, 0, n2);

        int i = 0, j =0, k = l;

        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])  arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }

    private void sort(int[] arr, int l, int r)
    {
        if(l < r)
        {
            int m = l + (r - l)/2;

            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public int[] sortArray(int[] nums)
    {
        sort(nums, 0, nums.length-1);
        return nums;
    }
}