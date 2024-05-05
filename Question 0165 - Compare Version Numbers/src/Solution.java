class Solution
{
    public int compareVersion(String version1, String version2)
    {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int n1 = ver1.length, n2 = ver2.length;
        int i = 0, j =0;

        while(i < n1 || j < n2)
        {
            int num1 = i < n1 ? Integer.parseInt(ver1[i]) : 0;
            int num2 = j < n2 ? Integer.parseInt(ver2[j]) : 0;

            if(num1 < num2) return -1;
            else if(num1 > num2) return 1;

            i++;
            j++;
        }
        return 0;
    }
}