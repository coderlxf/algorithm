function curry(func) {
    return function judge(...args) {
        return args.length === func.length ? func.apply(this, args) : (...arg) => judge(...args, ...arg)
    }
}

const curry = (func) =>
    judge = (...args) =>
        args.length === func.length
            ? func(...args)
            : (...arg) => judge(...args, ...arg)
