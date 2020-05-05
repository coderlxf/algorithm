// function deepClone(obj1) {
//     var obj2 = Array.isArray(obj1) ? [] : {};
//     if (obj1 && typeof obj1 === "object") {
//         for (var i in obj1) {
//             if (obj1.hasOwnProperty(i)) {
//                 var prop = obj1[i];
//                 // 如果子属性为引用数据类型，递归复制
//                 if (prop && typeof prop === "object") {
//                     obj2[i] = deepClone(prop);
//                 } else {
//                     // 如果是基本数据类型，只是简单的复制
//                     obj2[i] = prop;
//                 }
//             }
//         }
//     }
//     return obj2;
// }


// function deepClone(source, map = new WeakMap()) {
//     if (!isObject(source)) return source;
//     if (map.has(source)) return map.get(source);
//     var target = Array.isArray(source) ? [] : {};
//     map.set(source, target);
//     for (var key in source) {
//         console.log(Array.isArray(source),key);
//         if (source.hasOwnProperty(key)) {
//             if (isObject(source[key])) {
//                 target[key] = deepClone(source[key], map);
//             } else {
//                 target[key] = source[key];
//             }
//         }
//     }
//     return target;
// }

// function deepClone(x) {
//     const root = {};
//     // 栈
//     const loopList = [
//         {
//             parent: root,
//             key: undefined,
//             data: x,
//         }
//     ];
//     while (loopList.length) {
//         // 广度优先
//         const node = loopList.pop();
//         const parent = node.parent;
//         const key = node.key;
//         const data = node.data;
//         // 初始化赋值目标，key为undefined则拷贝到父元素，否则拷贝到子元素
//         let res = parent;
//         if (typeof key !== 'undefined') {
//             res = parent[key] = {};
//         }
//         for (let k in data) {
//             if (data.hasOwnProperty(k)) {
//                 if (typeof data[k] === 'object') {
//                     // 下一次循环
//                     loopList.push({
//                         parent: res,
//                         key: k,
//                         data: data[k],
//                     });
//                 } else {
//                     res[k] = data[k];
//                 }
//             }
//         }
//     }
//     return root;
// }

// 保持引用关系
function deepClone(x) {
    // =============
    const uniqueList = new WeakMap(); // 用来去重
    // =============
    let root = {};
    // 循环数组
    const loopList = [
        {
            parent: root,
            key: undefined,
            data: x,
        }
    ];
    while (loopList.length) {
        // 深度优先
        const node = loopList.pop();
        const parent = node.parent;
        const key = node.key;
        const data = node.data;

        // 初始化赋值目标，key为undefined则拷贝到父元素，否则拷贝到子元素
        let res = parent;
        if (typeof key !== 'undefined') {
            res = parent[key] = {};
        }
        // =============
        // 数据已经存在
        if (uniqueList.has(data)) {
            parent[key] = uniqueList.get(data);
            break; // 中断本次循环
        }
        // 数据不存在
        // 保存源数据，在拷贝数据中对应的引用
        uniqueList.set(data, res);
        // =============
        for (let k in data) {
            if (data.hasOwnProperty(k)) {
                if (typeof data[k] === 'object') {
                    // 下一次循环
                    loopList.push({
                        parent: res,
                        key: k,
                        data: data[k],
                    });
                } else {
                    res[k] = data[k];
                }
            }
        }
    }
    return root;
}

function isObject(source) {
    return typeof source === 'object' && source !== null;
}

(function test() {
    var obj = {
        a: 1,
        b: '2',
        c: [1, 2, 3],
        d: {
            e: 1,
            f: '2',
            g: {},
            h: {
                i: 1,
                j: '2'
            }
        }
    }
    obj.d.g = obj;
    var newObj = deepClone(obj);
    console.log(newObj);
})();