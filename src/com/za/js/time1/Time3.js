//bind
Function.prototype.ibind = function (thisArg) {
    if (typeof this !== 'function') throw TypeError('');

    let args = [...arguments].slice(1);

    thisArg = thisArg || window;

    var self = this;

    function F() {

    }

    const bound = function bound() {
        return self.apply(this instanceof F ? this : thisArg, args.concat([...arguments]));
    }

    if (this.prototype) {
        F.prototype = this.prototype;
    }

    bound.prototype = new F();

    return bound;
}

function test() {
    console.log(this.name, arguments);
}

const obj = {
    name: 'li'
}

test.prototype.name = 'gu';

const bound = test.ibind(obj, 4, 5, 6);

bound(7, 8, 9);

new bound(7, 8, 9);

//apply

Function.prototype.iapply = function (thisArg) {
    if (typeof this !== 'function') throw TypeError('');
    thisArg = thisArg || window;
    let args = [...arguments].slice(1);

    thisArg.fn = this;

    var result = thisArg.fn(args);

    delete thisArg.fn;

    return result;
}

//debounce
function debounce(func, timeout) {
    var task;
    return function () {
        var context = this;
        var args = arguments;
        if (task) clearTimeout(task)
        task = setTimeout(function () {
            func.apply(context, args);
        }, timeout);
    }
}

function debounce(func, timeout, immediate) {
    var task;
    return function () {
        var context = this;
        var args = arguments;
        immediate = immediate && !task;
        if (task) clearTimeout(task)
        task = setTimeout(function () {
            func.apply(context, args);
        }, timeout);
        immediate && func.apply(context, args);
    }
}

//throttle
function throttle(func, timeout) {
    var lastTime = 0;
    return function () {
        var context = this;
        var args = arguments;
        var nowTime = Date.now();
        if (nowTime - lastTime >= timeout) {
            func.apply(context, args);
            lastTime = nowTime;
        }
    }
}

function throttle(func, timeout) {
    var task;
    return function () {
        if (!task) {
            func.apply(this, arguments);
            task = setTimeout(function () {
                clearTimeout(task);
                task = null;
            }, timeout);
        }
    }
}

//new 
function newObject() {
    var args = [...arguments]
    var Constructor = args.shift();

    // var obj = Object.create(Constructor.prototype);

    // var obj = {};

    // obj.__proto__ = Constructor.prototype;

    const O = function () {
    }

    O.prototype = Constructor.prototype;

    var obj = new O();

    let ret = Constructor.apply(obj, args);

    return typeof ret === 'object' ? ret : obj;
}

//curry

const curry = (func) => verify = (...args) => args.length === func.length ? func(...args) : (...arg) => verify(...args, ...arg);






