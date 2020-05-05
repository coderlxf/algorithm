class Scheduler {
    constructor() {
        this.list = []   //promise list
        this.count = 0;
    }

    add(promiseCreator) {
        let p = new Promise(resolve => {
            this.list.push(() =>
                promiseCreator().then(() => {
                    resolve();
                    this.count--;
                    this.nextTask();
                })
            )
        });
        this.nextTask();
        return p;
    }

    nextTask() {
        while (this.list.length && this.count < 2) {
            this.list.shift()();
            this.count++;
        }
    }
}

const timeout = (time) => new Promise(resolve => {
    setTimeout(resolve, time)
})
const scheduler = new Scheduler()
const addTask = (time, order) => {
    scheduler.add(() => timeout(time)).then(() => console.log(order))
}

// const addTask = function (time, order) {
//     scheduler.add(function () {
//         return new Promise(resolve => {
//             setTimeout(resolve, time)
//         });
//     }).then(function () {
//         console.log(order)
//     })
// }

addTask(1000, '1');
addTask(500, '2');
addTask(300, '3');
addTask(400, '4');