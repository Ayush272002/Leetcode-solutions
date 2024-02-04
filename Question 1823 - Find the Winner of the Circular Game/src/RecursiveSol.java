public class RecursiveSol {
    public int findTheWinner(int n, int k) {
        //base case
        if(n==1) return 1;

        int winner = (findTheWinner(n-1,k)+k-1)%n +1;
        return winner;
    }
}
