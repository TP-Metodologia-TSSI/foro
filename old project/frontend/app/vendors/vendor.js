function getJson(myUrl){
    var Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("GET",myUrl,false);
    Httpreq.send(null);

    return JSON.parse(Httpreq.responseText);
}

function postJson(myUrl, jsonObject){
    var Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("POST", myUrl, true);
    Httpreq.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    Httpreq.send(JSON.stringify(jsonObject));

    return true;
}

exports.getJson = getJson;
exports.postJson = postJson;
