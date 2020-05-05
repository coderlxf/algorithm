//debounce
function debounce(fn, timeout) {
    var task;
    return function () {
        var context = this;
        var args = arguments;
        if (task) clearTimeout(task);
        task = setTimeout(function () {
            fn.apply(context, args);
        }, timeout);
    }
}

//throttle
function throttle(fn, timeout) {
    var time = 0;
    return function () {
        var now = Date.now();
        var context = this;
        var args = arguments;
        if (now - time > timeout) {
            fn.apply(context, args);
            time = now;
        }

    }
}

//bind

Function.prototype.bind = function (thisArg) {
    if (typeof this !== 'function') throw '';
    var self = this;
    var args = Array.prototype.splice.call(arguments, 1);

    function F() {

    }

    var bound = function () {
        return self.apply(this instanceof F ? this : thisArg, args.concat(Array.prototype.slice.call(arguments)));
    }

    if (this.prototype) {
        F.prototype = this.prototype;
    }

    bound.prototype = new F();

    return bound;
}