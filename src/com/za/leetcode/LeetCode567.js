var checkInclusion = function(s1, s2) {
    if(s1.length > s2.length) return false;
    var arr1 = new Array(26).fill(0);
    var arr2 = new Array(26).fill(0);
    for(var i=0;i<s1.length;i++){
        arr1[s1.charCodeAt(i)-97]++;
        arr2[s2.charCodeAt(i)-97]++;
    }
    for(var i=0;i<s2.length-s1.length;i++){
        if(isEqual(arr1,arr2)) return true;
        arr2[s2.charCodeAt(i+s1.length)-97]++;
        arr2[s2.charCodeAt(i)-97]--;
    }
    return isEqual(arr1,arr2);
};

function isEqual(arr1,arr2){
    for(var i=0;i<arr1.length;i++){
        if(arr1[i]!==arr2[i]) return false;
    }
    return true;
}

console.log(checkInclusion('ab','eidbaooo'));