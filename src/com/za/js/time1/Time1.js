function iNew() {
    var constructor = Array.prototype.shift.call(arguments);
    let obj = Object.create(constructor.prototype);
    var ret = constructor.apply(obj, arguments);
    return typeof ret === 'object' ? ret : obj;
}

function iBind(thisArg) {
    if (typeof this !== 'function') {
        throw TypeError("Bind must be called on a function");
    }

    var self = this;

    var args = Array.prototype.slice.call(arguments, 1);

    function F() {

    }

    function bound() {
        return self.apply(self instanceof F ? this : thisArg, args.concat(Array.prototype.slice.call(arguments)));
    }

    if (this.prototype) {
        F.prototype = this.prototype;
    }

    bound.prototype = new F();

    return bound;
}

Function.prototype.iApply = function (context, arr) {

    var self = this;

    context = context || window;

    context.fn = self;

    var result;

    if (!arr)

        result = eval('thisArg.fn()');
    else {

        var args = [];

        for (var i = 1; i < arr.length; i++) {
            args.push('arguments[' + i + ']');
        }

        result = eval('thisArg.fn(' + args + ')');

        delete context.fn;
    }

    return result;

}

Function.prototype.iApply = (context, arr) => {
    context = context || window;

    context.fn = this;
    var result;

    if (!arr)
        context.fn();
    else {
        // let args = Array.from(arguments).slice(1);
        let args = [...arguments].slice(1);

        result = context.fn(args);

        delete context.fn;
    }

    return result;
}

