Function.prototype.iBind = function (thisArg) {
    if (typeof this !== 'function') {
        throw TypeError("Bind must be called on a function");
    }
    const args = Array.prototype.slice.call(arguments, 0);
    let self = this;
    console.log('self',this);
    //防止修改bound的原型导致 调用对象的原型也被修改
    let nop = function () {

    }
    let bound = function () {
        console.log('bound',this);
        return self.apply(
            this instanceof nop ? this : thisArg, args.concat(Array.prototype.slice.call(arguments))
        );
    }
    console.log('this.prototype',this.prototype);
    console.log('bound.prototype',bound.prototype);
    if (this.prototype) {
        nop.prototype = this.prototype;
    }
    // 修改绑定函数的原型指向
    bound.prototype = new nop();
    return bound;
}
/**
 * 测试用例
 *  const bar = function() {
        console.log(this.name, arguments);
    };
    bar.prototype.name = 'bar';

    const foo = {
    name: 'foo'
    };
    const bound = bar.iBind(foo, 22, 33, 44);
    new bound(); // bar, [22, 33, 44]
    bound(); // foo, [22, 33, 44]
 */

Function.prototype.iCall = function (thisArg) {
    if (typeof this !== 'function') {
        throw TypeError("Bind must be called on a function");
    }
    const args = [...thisArg].slice(1);
    thisArg = thisArg || window;
    thisArg.fn = this;
    const result = thisArg.fn(...args);
    delete thisArg.fn;
    return result;
}

Function.prototype.iApply = function (thisArg) {
    thisArg = thisArg || window;
    thisArg.fn = this;
    const args = [...thisArg].slice(1);
    const result = thisArg.fn(args);
    delete thisArg.fn;
    return result;
}