function Father(name) {
    this.name = name;
}

Father.prototype.age = 30;
//原型链继承
// 无法向父类构造函数传参；所有实例共享父类属性
// function Child() {
//     this.name = 'lee'
// }
//
// Child.prototype = new Father();
// var c = new Child();
// console.log(c.age,c.name);
// console.log(c instanceof Father);

//构造函数继承
// 只继承父类构造函数的属性，无法继承父类原型属性；每个实例都有父类的构造函数
// function Child(){
//     Father.call(this,'li');
// }
//
// var c = new Child();
// console.log(c.age,c.name);
// console.log(c instanceof Father);

//构造函数原型链组合继承
// 调用了两次父类构造函数
// function Child(name) {
//     Father.call(this, name);
// }
//
// Child.prototype = new Father();
// var c = new Child('gu');
// console.log(c.age, c.name);
// console.log(c instanceof Father);

//原型式继承
//
// function inherits(obj) {
//     function f() {}
//     f.prototype = obj;
//     return new f();
// }
//
// var p = new Father('li');
// var c = inherits(p);
// console.log(c.age, c.name);
// console.log(c instanceof Father);
//寄生组合式继承
function inherits(Father,Child) {
    var proto = Object.create(Father.prototype);
    proto.constructor = Child;
    Child.prototype = proto;
}

function Child(name){
    Father.call(this,name);
}
inherits(Father,Child);
Child.prototype.age = 12;
var c = new Child('xu');
console.log(c.age, c.name);
console.log(c instanceof Father);