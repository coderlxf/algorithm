/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */

/**
 * initialize your data structure here.
 */
var MinStack = function () {
    this.stackA = [];
    this.stackB = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
    this.stackA.push(x);
    if (this.stackB.length === 0 || this.stackB[this.stackB.length - 1] >= x)
        this.stackB.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
    var x = this.stackA.pop()
    if (this.stackB.length > 0 && this.stackB[this.stackB.length - 1] === x)
        this.stackB.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
    if (this.stackA.length > 0)
        return this.stackA[this.stackA.length - 1]
};

/**
 * @return {number}
 */
MinStack.prototype.min = function () {
    if (this.stackB.length > 0)
        return this.stackB[this.stackB.length - 1]
};

var minStack = new MinStack()
minStack.push(0);
minStack.push(1);
minStack.push(0);
console.log(minStack.stackA);
console.log(minStack.stackB);
console.log(minStack.min());
minStack.pop();
console.log(minStack.top());
console.log(minStack.min());
