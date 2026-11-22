$(document).ajaxError(function (event, xhr, options, exc) {
    if (xhr.status == 400) {
        alert("参数校验失败");
    } else if (xhr.status == 401) {
        alert("用户未登录, 即将跳转到登录页!");
        //已经被拦截器拦截了, 未登录
        location.href = "blog_login.html";
    }
});

$(document).ajaxSend(function (e, xhr, opt) {
    var user_token = localStorage.getItem("user_token");
    xhr.setRequestHeader("user_token", user_token);
});

function getUserInfo(userUrl){
    $.ajax({
        type:"get",
        url: userUrl,
        success:function(result){
            if(result.code==200 && result.data!=null){
                $(".left .card h3").text(result.data.userName);
                $(".left .card a").attr("href",result.data.githubUrl);
            }
        }
    });
}
