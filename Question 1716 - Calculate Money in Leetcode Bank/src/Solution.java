class Solution
{
    public int totalMoney(int n)
    {
        int weeks = n/7;
        int days = n%7;

        int ans = ((weeks*(weeks-1))/2) * 7;
        ans += weeks * 28;
        ans += (days*(days+1))/2 + (weeks*days);
        return ans;

    }
}