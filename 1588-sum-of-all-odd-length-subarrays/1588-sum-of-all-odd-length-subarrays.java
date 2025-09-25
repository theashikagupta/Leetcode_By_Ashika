class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int sum=0;
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
           prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            int len=j-i+1;
            if(len%2!=0){
                sum+=prefix[j]-prefix[i];
            }
           }
        }
        return sum;
    }
}