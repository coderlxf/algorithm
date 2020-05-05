/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"
 链接：https://leetcode-cn.com/problems/multiply-strings
 */


var multiply = function (num1, num2) {
    if (num1 === '0' || num2 === '0') return '0';
    var length1 = num1.length;
    var length2 = num2.length;
    var result = new Array(length1 + length2).fill(0);
    var zero = '0'.charCodeAt(0);
    for (var i = length1 - 1; i >= 0; i--) {
        var n1 = num1.charCodeAt(i) - zero;
        for (var j = length2 - 1; j >= 0; j--) {
            var n2 = num2.charCodeAt(j) - zero;
            console.log(n1, n2);
            var sum = result[i + j + 1] + n1 * n2;
            console.log(sum);
            result[i + j] += parseInt(sum / 10);
            result[i + j + 1] = sum % 10;
            console.log(result);
        }
    }
    var total = '';
    for (var i = 0; i < result.length; i++) {
        if (result[i] !== 0)
            total += result[i];
    }
    return total;
};

console.log(multiply('25', '25'));
