class Solution {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target) return mid;
            if(nums[si]<=nums[mid]){    //left sorted
                if(nums[si]<=target && target<=nums[mid]){
                    ei=mid-1;
                }else{
                    si=mid+1;
                }
               
               
            }else{ //right sorted
                if(nums[mid]<=target && target<=nums[ei]){
                    si=mid+1;
                }else{
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
}

//  6 7| 0 1 2 3
//  mid=s+(e-s)/2 

// case1 : mid on line 1
//     case a :line1 k left side me ( arr[si]<=target<=arr[mid]);
//     case b : mid right 

// case 2: mid on line 2
//     case c: mid<=target<= end   line 2 right
//     case d :left of line 2 and line1  
