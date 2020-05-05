// bind

Function.prototype.iBind = function (thisArg) {
    if (typeof this !== 'function') throw '';
    thisArg = thisArg || window;
    let args = [...arguments].slice(1);
    let self = this;

    function F() {

    }

    const bound = function () {
        return self.apply(this instanceof F ? this : thisArg, [...arguments].concat(args));
    }

    if (this.prototype)
        F.prototype = this.prototype;

    bound.prototype = new F();

    return bound;
}

//call

Function.prototype.iCall = function (thisArg) {
    if (typeof this !== 'function') throw '';
    thisArg = thisArg || window;
    let args = [...arguments].slice(1);
    let self = this;

    self.fn = thisArg;

    let result = self.fn(...args);

    delete self.fn;

    return result;
}

//debounce

const debounce = function (func, timeout) {
    let task;
    let self = this;
    return function () {
        if (task) clearTimeout(task);
        task = setTimeout(() => {
            func.call(self, ...arguments);
        }, timeout);
    }
}

//throttle

const throttle = function (func, timeout) {
    let lastTime = 0;
    let self = this;
    return function () {
        let nowTime = Date.now();
        if (nowTime - lastTime > timeout) {
            func.call(self, ...arguments);
            lastTime = nowTime;
        }
    }
}

//jsonp

const jsonp = function ({url, params, callbackName}) {
    const getUrl = function () {
        if (!params) return `${url}?callback=${callbackName}`;
        let paramStr = '';
        for (let key in params) {
            paramStr += `${key}=${params[key]}&`;
        }
        return `${url}?${paramStr}callback=${callbackName}`
    }

    let scriptElement = document.createElement('script');
    scriptElement.src = getUrl();
    document.body.appendChild(scriptElement);

    return new Promise(resolve => {
        window[callbackName] = function (data) {
            resolve(data);
            document.body.removeChild(scriptElement);
        }
    })
}

//compose

const compose = function (...func) {
    if (func.length === 0) return arg => arg;
    if (func.length === 1) return func[0];
    return func.reduce((a, b) => (...arg) => a(b(arg)));
}

//deepClone

const deepClone = function (x, map = new WeakMap()) {
    const isObject = function (obj) {
        return typeof obj === 'object' && obj !== null;
    }

    if (isObject(x)) return x;

    if (map.has(x)) return map.get(x);
    let target = Array.isArray(x) ? [] : {};
    map.set(x, target);
    for (let key in x) {
        if (x.hasOwnProperty(key)) {
            if (isObject(x)) deepClone(x, map);
            else target.key = x[key];
        }
    }

    return target;
}

Promise.iAll = function (args) {
    if (!args.length) throw `${args} is not iterable`;
    let arr = [];
    if (args.length === 0) return Promise.resolve(arr);
    let count = 0;
    return new Promise((resolve, reject) => {
        for (let p of args) {
            Promise.resolve(p).then(res => {
                arr.push(res);
                if (++count === args.length) resolve(arr);
            }).catch(err => {
                reject(err);
                return;
            })
        }
    })
}

