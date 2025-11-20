class Solution {
    public int findTheWinner(int n, int k) {
        return Josephus(n ,k)+1;
    }
    public int Josephus(int n,int k){
        if(n==1) return 0;
        return (Josephus(n - 1, k) + k) % n;
        
    }
}