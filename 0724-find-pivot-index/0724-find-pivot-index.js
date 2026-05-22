/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    const left=new Array();
    left[0]=nums[0];
    for(let i=1; i<nums.length; i++){
        left[i]=left[i-1]+nums[i];
    }
    const right=new Array();
    right[nums.length-1]=nums[nums.length-1];
    for(let i=nums.length-2; i>=0; i--){
        right[i]=right[i+1]+nums[i];
    }
    for(let i=0; i<nums.length; i++){
        if(left[i]===right[i]) return i;
    }
    return -1;
};