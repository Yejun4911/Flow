function variableAdd() {
    const content = document.getElementById('content').value;
    $.ajax({
        type:"POST",
        url:"api/variable/add",
        data:{
            name : content
        },
        dataType: 'text',
        success : function (res){
            alert(res);
            window.location.reload();
        },
        error :function (XMLHttpRequest, textStatus, errorThrown){
            alert("실패");
        }
    })
}
function deleteVar(id){
    $.ajax({
        type:"DELETE",
        url : "api/variable/delete",
        data: {id:id},
        dataType : "text",
        success : function (res) {
            alert(res);
            window.location.reload();
        },
        error : function (res){
            alert(res)
        }
    })
}
function check(id){
    $.ajax({
        type: "POST",
        url:"api/fix/check",
        data : {id:id},
        dataType:'text',

        success : function (){
            console.log("sucess");
        },
        error:function (XMLHttpRequest, textStatus, errorThrown){
            alert("실패");
        }
    })
}
$(document).ready(function (){
    let div = "";
    const render = document.getElementById('fix');
    $.ajax({
        type : "get",            // HTTP method type(GET, POST) 형식이다.
        url : "api/fix/list",      // 컨트롤러에서 대기중인 URL 주소이다.

        success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            for (let i = 0; i < res.length; i++) {
                if(res[i].checked==1){
                    div += "<input type='checkbox' onclick='check("+res[i].id+")' id="+res[i].id+" checked>" +res[i].name;
                } else {
                    div += "<input type='checkbox' onclick='check("+res[i].id+")' id="+res[i].id+">" +res[i].name;
                }
            }
            render.innerHTML = div;

        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("통신 실패.")
        }
    });
    const render1 = document.getElementById('count');
    $.ajax({
        type:"get",
        url : "api/variable/count",

        success : function (res) {
            render1.innerHTML = res+"/200";
        }
    })
    let div2 = "";
    const render2 = document.getElementById('variable');
    $.ajax({
        type : "get",            // HTTP method type(GET, POST) 형식이다.
        url : "api/variable/list",      // 컨트롤러에서 대기중인 URL 주소이다.

        success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            for (let i = 0; i < res.length; i++) {
                div2 += "<span id = 'variable' onclick='deleteVar("+res[i].id+")'>"+res[i].name+"<img src='/images/close.png' height='10px' width='10px'></span>&nbsp;"

            }
            render2.innerHTML = div2;

        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("통신 실패.")
        }
    });

})
