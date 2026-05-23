/**
 * @param {number[]} arr
 * @return {number}
 */
var longestMountain = function(arr) {
    let count; let maxCount=0;
        for(let i=1; i<arr.length-1; i++){

            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
               
                count=1;
                let l=i;
                while(l>0 && arr[l]>arr[l-1]){
                    count++;
                    l--;
                }
                let r=i;
                while(r<arr.length-1 && arr[r]>arr[r+1]){
                    count++;
                    r++;
                }
                maxCount=Math.max(maxCount,count);
               
            }
          
            
        }
        return maxCount;
};