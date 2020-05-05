function newObj() {
    let constructor = Array.prototype.shift.call(arguments);
    //创建一个空的对象,将空对象指向构造函数的原型链
    // let obj = Object.create(Constructor.constructor);
    let obj = {};
    obj.__proto__ = constructor.prototype;
    /**
     * var F = function(){}
     * F.prototype = constructor.prototype
     * obj = new F();
     */
    //obj绑定到构造函数上，便可以访问构造函数中的属性
    let result = constructor.apply(obj, arguments)
    //如果返回的result是一个对象则返回该对象，new方法失效，否则返回obj
    return result instanceof Object ? result : obj;
}


function Test(name, age) {
    this.name = name;
    this.age = age;
}

!function test() {
    let test = newObj(Test, 'yin', 20);
    console.log(test);
    console.log(test.name);//yin
    console.log(test.age);//20
}();