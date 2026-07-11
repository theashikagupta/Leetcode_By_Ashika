class Solution {
    public boolean lemonadeChange(int[] bill) {
        int five=0, ten=0;
        for(int i=0; i<bill.length; i++){
            if(bill[i]==5){
              five++;
            }
            else if(bill[i]==10){
               if(five==0){
                 return false;
                }
                five--;
                ten++;
            }else{
                if(ten>0 && five>0){
                   ten--;
                   five--;
                }else if(five>=3){
                   five-=3;
                }else{
                  return false;
                }
            }
        
        }
        return true;
   }
}