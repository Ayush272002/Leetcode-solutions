class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0;
        int start = 0;
        int balance  =0;
        for(int i=0; i < gas.length ; i++)
        {
            balance  = balance + gas[i] -cost[i];
            if(balance < 0)
            {
                start = i+1;
                deficit = deficit + balance;
                balance = 0;
            }
        }

        if(deficit+balance >= 0 ) return start;
        return -1;

    }
}