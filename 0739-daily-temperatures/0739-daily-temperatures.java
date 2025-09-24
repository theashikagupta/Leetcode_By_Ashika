class Solution {
    public int[] dailyTemperatures(int[] temperatures) { //decreasing monotonic stack
        Stack<Integer> s=new Stack<>();
        int n=temperatures.length;
        int[] day=new int[n];
        for(int i=n-1;i>=0;i--){
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if(!s.isEmpty()){
                day[i]=s.peek()-i;
            }
            s.push(i);
        }
        return day;
    }
}