class EventEmitter {
    constructor() {
        this.events = {};
    }

    on(eventType, handler) {
        let handlers = this.events[eventType] || [];
        handlers.push(handler);
        this.events[eventType] = handlers;
    }

    off(eventType, handler) {
        let handlers = this.events[eventType];
        if (handlers && handlers.includes(handler)) {
            console.log('off',handlers.indexOf(handler));
            handlers.splice(handlers.indexOf(handler), 1);
        }
    }

    emit(...args) {
        let eventType = args[0];
        let params = Array.prototype.slice.call(args, 1);
        let handlers = this.events[eventType] || [];
        handlers.forEach(h => {
            h.apply(this, params);
        });
        return this;
    }

    once(eventType, handler) {
        let onceFunc = (...args) => {
            handler.apply(this, args);
            this.off(eventType, onceFunc);
        }
        this.on(eventType, onceFunc);
    }
}

function test() {
    let event = new EventEmitter();
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

    event.emit('event1') //event1 callback    event1.1 callback
    event.emit('event1', 'a', 'b', 'c') //event1 callback,a,b,c event1.1 callback

    event.off('event1', callback1);

    event.emit('event1')//event1.1 callback

    event.emit('event3');//event3 callback
    event.emit('event3');//

}

test();