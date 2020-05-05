function sum() {
    var arr = [];
    arr.push(...arguments);
    var tmp = function () {
        arr.push(...arguments);
        return tmp;
    }
    tmp.valueOf = function () {
        return arr.reduce(function (a, b) {
            return a + b;
        }, 0);
    }
    return tmp;
}

console.log(sum(1, 2, 3)(4)(5).valueOf());
console.log(sum(1, 2)(3)(4)(5).valueOf());
console.log(sum().valueOf());

// function add(x) {
//     var sum = x;
//     var tmp = function (y) {
//         sum = sum + y;
//         return tmp;
//     };
//     tmp.toString = function () {
//         return sum;
//     };
//     return tmp;
// }
//
// console.log(add(1)(2));

function add() {
    var arr = [...arguments];
    var sumF = function () {
        if (arguments.length === 0){
            return arr.reduce(function(a, b){
                return a + b;
            },0);
        }
        arr.push(...arguments);
        return sumF;
    }
    return sumF;
}

console.log(add(1, 2)());
console.log(add(1, 2)(3)());

