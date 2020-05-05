function compose(...func) {
    if (func.length === 0) {
        return arg => arg;
    }
    if (func.length === 1) {
        return func[0];
    }
    return func.reduce((a, b) => (...arg) => a(b(arg)));
}

function compose() {
    var func = [];
    for (var i = 0; i < arguments.length; i++) {
        func[i] = arguments[i];
    }
    if(func.length ===0){
        return function(arg){
            return arg;
        }
    }
    if(func.length === 1){
        return func[0];
    }
    return func.reduce(function(a,b){
        return function(){
            return a.call(undefined,b.apply(undefined,arguments))
        }
    })
}