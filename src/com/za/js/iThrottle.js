function throttle(func, timeout) {
    var preTime = 0;
    return function () {
        var nowTime = Date.now();
        var context = this;
        var args = arguments;
        if (nowTime - preTime > timeout) {
            func.call(context, args);
            preTime = nowTime;
        }
    }
}

function throttle(func, timeout) {
    var timeout;
    return function () {
        var context = this;
        var args = arguments;
        if (!timeout) {
            timeout = setTimeout(function () {
                func.call(context, args);
                timeout = null;
            }, timeout)
        }
    }
}

