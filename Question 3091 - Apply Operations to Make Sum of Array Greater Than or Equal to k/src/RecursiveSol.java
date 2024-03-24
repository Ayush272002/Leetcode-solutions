class RecursiveSol
{
    private int solve(int num, int max, int k)
    {
        //base case
        if(num >= k) return 0;

        //add 1
        int add = 1 + solve(num+1, max+1, k);

        //multiply
        int mul = 1 + solve(num + max, max, k);

        return Math.min(add,mul);
    }
    public int minOperations(int k)
    {
        int num = 1;
        int max = 1;
        return solve(num,max,k);
    }
}