class Solution {
    public int pivotInteger(int n)
    {
        /*
        Let the no. be x
        sum till x = sum from x to n (sum till n - sum till x-1)
        x(x+1)/2 = n(n+1)/2  -  (x-1)(x)/2
        x^2 = n(n+1)/2
         */

        int sum = (n*(n+1))/2;
        double ans = Math.sqrt(sum);
        int check = (int) ans;

        return check == ans ? check : -1;
    }
}