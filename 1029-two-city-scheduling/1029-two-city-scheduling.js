/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function(costs) {

    let totalCost = 0;
    costs.sort((a, b) => a[0] - a[1] - (b[0] - b[1]));
    let costLength = costs.length;
    for (let i = 0; i < Math.floor(costLength / 2); i++) {
        totalCost += costs[i][0] + costs[costLength - i - 1][1];
    }
    return totalCost;

};