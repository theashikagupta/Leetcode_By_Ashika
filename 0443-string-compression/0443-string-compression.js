/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
   let i=0;
   let j=0;
   while(j<chars.length){
     let currChar=chars[j];
     let count=0;
     while(j<chars.length && chars[j]==currChar){
        count++;
        j++;
     }
     chars[i]=currChar;
     i++;
     if(count>1){
        let countStr=count.toString();
        // for(let k=0; k<countStr.length; k++){
        //   chars[i]=countStr[k];
        //   i++;
        // }
        for(let c of countStr){
            chars[i]=c;
            i++;
        }
     }
  
   }
    return i;
};