const reverseNum = function (num) {
    var result = 0;
    while (num) {
        result = result * 10 + num % 10;
        num = Math.floor(num / 10);
    }
    return result;
}

console.log(reverseNum(12345));