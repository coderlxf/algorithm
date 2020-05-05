const jsonp = ({url, params, callbackName}) => {
    const getURI = () => {
        if (!params) return `${url}?callback=${callbackName}`;
        let dataStr = '';
        for (let key in params) {
            dataStr += `${key}=${params[key]}&`;
        }
        dataStr += `callback=${callbackName}`;
        return `${url}?${dataStr}`;
    }
    return new Promise((resolve, reject) => {
        let scriptEle = document.createElement('script');
        scriptEle.src = getURI();
        document.body.appendChild(scriptEle);
        window[callbackName] = (data) => {
            resolve(data);
            document.body.removeChild(scriptEle);
        }
    }).catch(err => {

    });
}