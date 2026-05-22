/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    let str="";
    let i=0 , j=0;
    let flag=true;
    while(i<word1.length && j<word2.length){
      if(flag){
        str=str.concat(word1.charAt(i));
        i++;
        flag=!flag;
      }
      else{
        str=str.concat(word2.charAt(j));
        j++;
        flag=!flag;
      }
    }
    while(i<word1.length || j<word2.length){
        if(i<word1.length){
        str=str.concat(word1.charAt(i));
        i++;
    }
    if(j<word2.length){
        str=str.concat(word2.charAt(j));
        j++;
    }
    }
    return str;
};