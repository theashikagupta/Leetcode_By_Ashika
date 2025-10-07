class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n=squares(n);
        }
        return n==1;
    }
    private int squares(int n){
        
        int sum=0;
        while(n>0){
            int digit=n%10;
            int square=digit*digit;
            sum+=square;
            n/=10;
        }
        return sum;
    }
}