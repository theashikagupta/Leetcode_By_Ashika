/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const n=nums.length;
    let map=new Map();
    for(let num of nums){
        map.set(num,(map.get(num)||0)+1);
        if(map.get(num)>n/2){
            return num;
        }
    }
    return -1;

};



// int n=nums.length;
//         // HashMap<Integer,Integer> map=new HashMap<>();
        
//         // for(int num:nums){
//         //     map.put(num,map.getOrDefault(num,0)+1);
//         //     if(map.get(num)>n/2){
//         //         return num;
//         //     }
//         // }
//         // return -1;

//         //Moore Voting Algorithm
//         int count=1;
//         int candidate=nums[0];
//         for(int i=1;i<n;i++){
//             if(candidate==nums[i]){
//                 count++;
//             }else{
//                 count--;
//             }
//             if(count==0){
//                 candidate=nums[i];
//                 count=1;
//             }
           
//         }
//          return candidate;