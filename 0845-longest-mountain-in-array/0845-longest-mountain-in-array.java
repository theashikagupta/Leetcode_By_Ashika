class Solution {
    public int longestMountain(int[] arr) {
        int count=0; 
        int inc=0, dec=0;
        int maxInc=0, maxDec=0;
        int i=0;
        
        while (i < arr.length - 1) {
    // 1. Check this FIRST: If we were going down, but now we are going up, 
    // it means a new mountain is starting. Reset counters first.
    if (arr[i] < arr[i + 1] && dec > 0) {
        inc = 1;
        dec = 0;
        i++;
    }
    // 2. Otherwise, if it's just a normal upward slope step
    else if (arr[i] < arr[i + 1]) {
        inc++;
        i++;
    }
    // 3. Normal downward slope step
    else if (arr[i] > arr[i + 1] && inc > 0) {
        dec++;
        i++;
        // Track the valid mountain length dynamically right here!
        count = Math.max(count, inc + dec + 1); 
    }
    // 4. Flat ground (arr[i] == arr[i+1]) or going down without a peak
    else {
        inc = 0;
        dec = 0;
        i++;
    }
}
return count;
        
    }
    
}