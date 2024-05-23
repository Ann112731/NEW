function changeRegist(){
    document.getElementById("config").style.display="none";
    document.getElementById("regist").style.display="block";
  }
  function changeLogin(){
    document.getElementById("config").style.display="block";
    document.getElementById("regist").style.display="none";
  }

function submit(){
    if($("#uid").val()=='' || $("#pwd").val()==''){
        $("#empty").modal('show');
    }else{
        $.ajax({
            type: 'POST',
            url: '/login',
            data: {
                uid:$("#uid").val(),
                pwd:$("#pwd").val(),
                choose: $("input[type='radio']:checked").val(),
            },
            success:function (data) {
                if(data == "success"){
                    $('#modallogin').modal('show');
                    setTimeout(function(){
                        if($("input[type='radio']:checked").val() == 'a'){
                            window.location.href="admin_index.html";
                        }else{
                            window.location.href="index.html";
                        }

                    }, 1000);
                }else{
                    $('#modalDeny').modal('show');
                }
            }
        })
    }

}


function submitRegist(){
    if($("#pwd2").val() == '' || $("#uid2").val() == ''){
        $("#empty").modal('show');
    }else {
        if($("#pwd2").val() == $("#pwdConfirm").val()){
            $.ajax({
                type: 'POST',
                url: '/regist',
                data: {
                    uid2:$("#uid2").val(),
                    pwd2:$("#pwd2").val(),
                },
                success:function (data) {
                    $('#registsuccess').modal('show');
                    setTimeout(function(){
                        document.getElementById("cancle").click();
                        $('#registsuccess').modal('hide');
                    }, 1000);
                    $("#uid").val($("#uid2").val());
                }
            })
        }else{
            $('#modalregist').modal('show');
        }
    }


}
