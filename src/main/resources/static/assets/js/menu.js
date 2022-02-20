async function fetchAsync (url) {
    let response = await fetch(url);
    let data = await response.json();
    return data;
}
$(document).ready(function(){
/*    window.location.href = "https://www.hvu.edu.vn/";*/
    $.get("https://www.hvu.edu.vn/", function(datas, status){
        let menu = datas.substring(datas.indexOf("navbar-nav"), datas.indexOf('<div id="wrapdiv"'));
        menu = menu.replaceAll("</a>","</a></li>,")
        menu = menu.replaceAll(",</li>",',');
        let menuArr = menu.split(',');
        let obj = [{
            meName: '',
            meLink: ''
        }]
        menuArr.forEach(function (m){
            let href = m.substring(m.indexOf('href=')+6, m.indexOf('title')-1)
            let nameMenu = m.substring(m.indexOf('title=')+6, m.lastIndexOf('">'))
            let index = nameMenu.indexOf('"');
            if(index !== -1){
                nameMenu = nameMenu.replaceAll('"','');
            }
            obj.push({meName: nameMenu,meLink: href})
        })

        // obj = JSON.stringify(obj)
        // $.ajax({
        //     url: 'http://localhost:8080/',
        //     type: 'POST',
        //     contentType: "application/json; charset=utf-8",
        //     data: obj,
        //     success: function (data) {
        //
        //     }
        // })
    });
/*   getDataMenu();*/
});
/*
function getDataMenu(){
    let url= "https://www.hvu.edu.vn/"
    let data = fetchAsync(url);
    console.log(data)
}*/
