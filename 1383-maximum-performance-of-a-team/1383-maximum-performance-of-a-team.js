/**
 * @param {number} n
 * @param {number[]} speed
 * @param {number[]} efficiency
 * @param {number} k
 * @return {number}
 */
var maxPerformance = function(n, speed, efficiency, k) {
    // 1. store speed,eff in objects
    const engineer = [];
    for (let i = 0; i < n; i++) {
        engineer.push({ speed: speed[i], efficiency: efficiency[i] });
    }
    
    // 2. sort it w.r.t eff in desc order
    engineer.sort((a, b) => b.efficiency - a.efficiency);

    const minHeap = new MinPriorityQueue({ compare: (a, b) => a - b });
    
    // Initialize tracked values
    let sum = 0n;     
    let maxPerf = 0n; 
    const MOD = BigInt(1e9 + 7); 

    // 4. for(i=0 to n-1)
    for (let i = 0; i < n; i++) {
        const currSpeed = BigInt(engineer[i].speed);
        const currEff = BigInt(engineer[i].efficiency);
        
        if (minHeap.size() < k) {
            minHeap.enqueue(engineer[i].speed);
            sum += currSpeed;
            
            let perf = sum * currEff;
            if (perf > maxPerf) maxPerf = perf;
            continue;
        }
    
        if (engineer[i].speed > minHeap.front()) {
            const removedSpeed = BigInt(minHeap.dequeue());
            sum -= removedSpeed;
            
            sum += currSpeed;
            minHeap.enqueue(engineer[i].speed);
            
            let perf = sum * currEff;
            if (perf > maxPerf) maxPerf = perf;
        }
    }
    
    return Number(maxPerf % MOD);
};