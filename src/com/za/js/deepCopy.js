function deepCopy(obj, map = new WeakMap()) {
    if (!isObject(obj)) return obj;
    if (map.has(obj)) return map.get(obj);
    let newObj = Array.isArray(obj) ? [] : {};
    map.set(obj, newObj);
    for (let key in obj) {
        if (obj.hasOwnProperty(key)) {
            if (isObject(key)) deepCopy(obj, map);
            else newObj[key] = obj[key];
        }
    }
    return newObj;
}

function isObject(obj) {
    return typeof obj === 'object' && obj !== null;
}

(function test() {
    let obj = {
        name: 'li',
        age: 22,
        arr: [1, 2, 3],
        func: function () {
            return 0;
        },
        o: {
            a: 1,
            b: '',
            c: [1, 2, 3]
        },
        d: new Date()
}
    console.log(obj);
    let nObj = deepCopy(obj);
    console.log(nObj);
})()