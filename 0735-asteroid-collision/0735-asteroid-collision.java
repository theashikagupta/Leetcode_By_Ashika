class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int num:asteroids){
           while(!s.isEmpty() && s.peek()>0 && num<0){
             int sum=s.peek()+num;
             if(sum<0){
                s.pop();
             } else if(sum>0){
                num=0;
             
             }else{
                s.pop();
                num=0;
             }
           }
           if(num!=0){
             s.push(num);
           }
          
        }   
        int size=s.size();
        int[] res=new int[size];
        for(int i=size-1;i>=0;i--){
            res[i]=s.peek();
            s.pop();
        }
        return res;
    }
}