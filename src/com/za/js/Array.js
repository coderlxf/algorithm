function iMap(arr, callbackFn, thisArg) {
    if (!arr || !arr.length || typeof callbackFn !== 'function') {
        return null;
    }
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        result.push(callbackFn.call(thisArg, arr[i], i, arr));
    }
    return result;
}

function iFilter(arr, callbackFn) {
    if (!arr || !arr.length || typeof callbackFn !== 'function') {
        return null;
    }
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        if (callbackFn(arr[i], i, arr))
            result.push(arr[i]);
    }
    return result;
}

function iReduce(arr, callbackFn, initialValue) {
    if (!arr || !arr.length || typeof callbackFn !== 'function') {
        return null;
    }
    console.log(initialValue);
    let value = arguments.length == 3 ? initialValue : arr[0];
    for (let i = arguments.length == 3 ? 0 : 1; i < arr.length; i++) {
        value = callbackFn(value, arr[i], i, arr);
    }
    return value;
}

(function test() {
    let arr = [1, 2, 3, 4, 5, 6];
    let result = iMap(arr, (e, i, arr) => {
        console.log(e + "," + i + "|" + arr);
        return e * 2;
    });
    console.log('map:', result);
    result = iFilter(arr, (e, i, arr) => {
        return e % 2 == 0;
    })
    console.log('filter:', result);
    arr.reduce((v, c, i) => {
        console.log("reduce:" + i, v);
        v += c;
        return v;
    });
    iReduce(arr, (v, c, i) => {
        console.log(i, v);
        v += c;
        return v;
    });
}())