

    function $(selector){
        return document.querySelector(selector)
    }

    function ajax(obj, callback){
        let xhr = new XMLHttpRequest()
        xhr.open(obj.method, obj.url)
        if (obj.contentType){
            xhr.setRequestHeader('Content-Type', obj.contentType)
        }
        xhr.send(obj.data)
        xhr.onreadystatechange = function (e){
            if (this.readyState === 4){
                callback(xhr.responseText)
            }
        }
    }