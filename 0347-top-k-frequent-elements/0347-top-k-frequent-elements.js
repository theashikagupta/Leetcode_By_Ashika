/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    let freq=new Map();
    for(let num of nums){
      freq.set(num,(freq.get(num)||0)+1);
    }
    const arr=[...freq.keys()];
    arr.sort((a,b)=> freq.get(b)-freq.get(a));

    return arr.slice(0,k);
    
};