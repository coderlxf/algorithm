function debounce(func, timeout) {
    var timer;
    return function () {
        let context = this;
        let args = arguments;
        if (timer !== null) {
            clearTimeout(timer);
        }
        timer = setTimeout(function () {
            func.call(context, args);
        }, timeout)
    }
}

function debounce(func, timeout) {
    var timer;
    return function () {
        let context = this;
        let args = arguments;
        var immediate = !timer;
        if (timer !== null) {
            clearTimeout(timer);
        }
        timer = setTimeout(function () {
            func.call(context, args);
        }, timeout)
        if (immediate) func.call(context, args);
    }
}