class Solution {
    public int totalMoney(int n) {
        int result=0;
        int monday_money=1;
        while(n>0){
            int money=monday_money;
            for(int day=1; day<=Math.min(n,7); day++){
                result+=money;
                money++;
            }
            n=n-7;
            monday_money++;
        }
        return result;
    }
}