//EventEmitter
class EventEmitter {
    constructor() {
        this.EVENT = {};
    }

    on(eventType, handler) {
        let handlers = this.EVENT[eventType] || [];

        handlers.push(handler);

        this.EVENT[eventType] = handlers;
    }

    once(eventType, handler) {
        const callback = () => {
            handler();
            this.off(eventType, callback);
        }
        this.on(eventType, callback);
    }

    emit(...args) {
        let eventType = args.shift();

        let handlers = this.EVENT[eventType];

        handlers && handlers.map(h => {
            h(args);
        })
    }

    off(eventType, handler) {
        let handlers = this.EVENT[eventType];
        if (handlers) {
            let index = handlers.indexOf(handler);
            if (index > -1)
                handlers.splice(index, 1);
        }
    }
}

function test() {
    let event = new EventEmitter();
    console.log(event.EVENT);
    let callback1 = (...params) => {
        console.log('event1 callback' + ',' + params);
    }
    event.on("event1", callback1);
    event.on("event1", () => {
        console.log('event1.1 callback')
    });
    event.on("event2", callback1);
    event.on("event2", () => {
        console.log('event2.1 callback');
    });
    event.once('event3', () => {
        console.log('event3 callback');
    })

    event.emit('event1') //event1 callback,    event1.1 callback
    event.emit('event1', 'a', 'b', 'c') //event1 callback,a,b,c event1.1 callback

    event.off('event1', callback1);

    event.emit('event1')//event1.1 callback

    event.emit('event3');//event3 callback

    event.emit('event2',2) //event1 callback  event2.1 callback

    event.emit('event3');//

    event.off('event2', callback1);

    event.emit('event2',2) //event2.1 callback

}

test();