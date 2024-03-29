class SolutionUsingRecursion
{
    private int solve(int[] arr, int d, int idx)
    {
        //base case
        if(idx < 0 || idx >= arr.length) return 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= d; i++)
        {
            if(i + idx < arr.length && arr[i + idx] < arr[idx]) max = Math.max(max,1+ solve(arr,d, i + idx));
            else break;
        }

        for(int i = 1; i <= d; i++)
        {
            if(idx - i >=0 && arr[idx-i] < arr[idx]) max = Math.max(max,1+ solve(arr,d, idx-i));
            else break;
        }

        return max;
    }
    public int maxJumps(int[] arr, int d)
    {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, solve(arr,d,i));
        }

        return max;
    }
}