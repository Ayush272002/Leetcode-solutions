class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x;
        long ans = -1;

        while(s <= e) {
            long mid = s + (e-s)/2;

            long sq = mid*mid;

            if(sq == x) return (int) mid;

            if(sq > x){
                e = (int) mid-1;
            }else{
                ans = mid;
                s = (int) mid+1;
            }
        }

        return (int) ans;
    }
}