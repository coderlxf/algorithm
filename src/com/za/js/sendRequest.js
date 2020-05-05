function sendRequest(urls, max, callback) {
    let queue = [];
    let count = 0;
    let total = 0;
    urls.forEach(url => {
        queue.push(() =>
            fetch(url).then(res => {
                console.log(res);
                count--;
                total++;
                nextTask();
            }));
    })

    nextTask();

    function nextTask() {
        if (total === urls.length) callback();
        else {
            while (queue.length && count < max) {
                queue.shift()();
                count++;
            }
        }
    }
}

sendRequest(['http://t.weather.sojson.com/api/weather/city/101030100', 'http://t.weather.sojson.com/api/weather/city/101030100', 'http://t.weather.sojson.com/api/weather/city/101030100', 'http://t.weather.sojson.com/api/weather/city/101030100', 'http://t.weather.sojson.com/api/weather/city/101030100'], 2, () => {
    console.log('success');
})
