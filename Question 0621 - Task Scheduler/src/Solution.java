class Solution
{
    public int leastInterval(char[] tasks, int n)
    {
        if(n==0) return tasks.length;
        int[] freq = new int[26];
        int mf = Integer.MIN_VALUE;
        for(char c : tasks)
        {
            freq[c-'A']++;
            mf = Math.max(mf,freq[c-'A']);
        }

        int mfCount = 0;

        for (int i = 0; i < freq.length; i++)
        {
            if(freq[i] == mf) mfCount++;
        }

        int interval = (n+1)*(mf-1) + mfCount;
        /*
        n+1 : tym needed to complete one cycle of tasks along with cooling tym
        mf-1 : ignoring the last task, time required to complete all those tasks
        there could be two max freq task, so to handle them we add mfcount and also we excluded the last task.
         */
        return Math.max(tasks.length, interval);
    }
}