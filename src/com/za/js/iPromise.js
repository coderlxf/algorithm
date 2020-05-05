/**
 * https://juejin.im/post/5c88e427f265da2d8d6a1c84#heading-25
 */
const PENDING = 'pending';
const FULFILLED = 'fulfilled';
const REJECTED = 'rejected';

function Promise(executor) {
    let self = this;
    self.status = PENDING;
    self.onFulfilled = [];
    self.onRejected = [];

    function resolve(value) {
        if (self.status === PENDING) {
            self.status = FULFILLED;
            self.value = value;
            self.onFulfilled.forEach(fn => fn());
        }
    }

    function reject(err) {
        if (self.status === PENDING) {
            self.status = REJECTED;
            self.reason = err;
            self.onRejected.forEach(fn => fn());
        }
    }

    try {
        executor(resolve, reject);
    } catch (e) {
        reject(e);
    }
}

Promise.prototype.then = function (onFulfilled, onRejected) {
    onFulfilled = typeof onFulfilled === 'function' ? onFulfilled : value => value;
    onRejected = typeof onRejected === 'function' ? onRejected : reason => {
        throw reason;
    };
    let self = this;
    let rPromise = new Promise((resolve, reject) => {
        if (self.status === FULFILLED) {
            setTimeout(() => {
                try {
                    let x = onFulfilled(self.value);
                    resolvePromise(rPromise, x, resolve, reject);
                } catch (e) {
                    reject(e);
                }
            }, 0);
        } else if (self.status === REJECTED) {
            setTimeout(() => {
                try {
                    let x = onRejected(self.reason);
                    resolvePromise(rPromise, x, resolve, reject);
                } catch (e) {
                    reject(e);
                }
            }, 0);
        } else if (self.status === PENDING) {
            self.onFulfilled.push(() => {
                setTimeout(() => {
                    try {
                        let x = onFulfilled(self.value);
                        resolvePromise(rPromise, x, resolve, reject);
                    } catch (e) {
                        reject(e);
                    }
                }, 0);
            });
            self.onRejected.push(() => {
                setTimeout(() => {
                    try {
                        let x = onRejected(self.reason);
                        resolvePromise(rPromise, x, resolve, reject);
                    } catch (e) {
                        reject(e);
                    }
                }, 0);
            });
        }
    });
    return rPromise;
}

function resolvePromise(rPromise, x, resolve, reject) {
    if (rPromise === x)
        reject(new TypeError('Chaining cycle'));
    if (x && (typeof x === 'object' || typeof x === 'function')) {
        let called = false;
        try {
            let then = x.then;
            if (typeof then === 'function') {
                then.call(x, (y) => {
                    if (called) return;
                    called = true;
                    resolvePromise(rPromise, y, resolve, reject);
                }, (r) => {
                    if (called) return;
                    called = true;
                    reject(r);
                })
            } else {
                if (called) return;
                called = true;
                resolve(x);
            }
        } catch (e) {
            if (called) return;
            called = true;
            reject(e);
        }
    } else {
        resolve(x);
    }
}

Promise.All = (args) => {
    let total = 0;
    let result = [];
    return new Promise((resolve, reject) => {
        //传空数组，resolve，防止一直处于pending
        if(args.length ===0) {
            resolve(result);
            return;
        }
        for (let i = 0; i < args.length; i++) {
            Promise.resolve(args[i]).then(res => {
                result[i] = res;
                total++;
                if (total === args.length) {
                    resolve(result);
                    return;
                }
            }, rej => {
                reject(rej);
            }).catch(err => {
                reject(err);
            });
        }

    });
}
/**
 * Promise.all([Promise.resolve(0),Promise.reject(1)]).then(res=>{console.log(res),rej=>{console.log(rej)}}).catch(err=>{console.log(err)});
 *
 */
Promise.Race = (args) => {
    return new Promise((resolve, reject) => {
        if(args.length ===0) return;
        for (let i = 0; i < args.length; i++) {
            Promise.resolve(args[i]).then(res => {
                resolve(res);
                return;
            }, rej => {
                reject(rej);
            }).catch(err => {
                reject(err);
            })
        }
    })
}

// 用于promise方法链时 捕获前面onFulfilled/onRejected抛出的异常
Promise.prototype.catch = function (onRejected) {
    return this.then(null, onRejected);
}

Promise.resolve = function (value) {
    return new Promise(resolve => {
        resolve(value);
    });
}

Promise.reject = function (reason) {
    return new Promise((resolve, reject) => {
        reject(reason);
    });
}

Promise.defer = Promise.deferred = function () {
    let dfd = {};
    dfd.promise = new Promise((resolve, reject) => {
        dfd.resolve = resolve;
        dfd.reject = reject;
    });
    return dfd;
}

module.exports = Promise;