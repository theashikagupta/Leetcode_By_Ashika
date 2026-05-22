/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    strs.sort();
    let s = "";
    let i = 0;
    let length = strs.length;

    while (i < strs[0].length) {
        if (strs[0][i] === strs[length - 1][i])
            s += strs[0][i];
        else
            break;
        i++;
    }

    return s;
};