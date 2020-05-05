function pow(x, n) {
    if (n === 0) return 1;
    // if (n === 1) return x;
    if (n < 0) return 1 / pow(x, -n);
    else if (n % 2 === 0) return pow(x * x, n >>> 1);
    else return pow(x, (n - 1)) * x;
}

(function () {
    console.log(pow(2, 10));
    console.log(pow(2, -1));
})();

function pow(x, n) {
    if (n === 0) return 1;
    if (n < 0) return 1 / pow(x, -n);
    var ans = 1;
    var tmp = x;
    while (n > 0){
        if(n & 1){
            ans *= tmp;
        }
        tmp *= tmp;
        n >>= 1;
    }
    return ans;
}

(function () {
    console.log(pow(2, 10));
    console.log(pow(2, -1));
})();