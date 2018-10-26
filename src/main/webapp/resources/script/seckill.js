//存放主要交互逻辑
//javascript模块化
var seckill={
    //封装秒杀相关ajax的url
    URL :{

    },
    //验证手机号
    validatePhone: function (phone) {
      if(phone && phone.length==9 && !isNaN(phone)){
          return true;
      }else{
          return false;
      }
    },
    //详情秒杀逻辑
    detail:{
        //详情页初始化
        init:function (params) {
            //手机验证和登录，计时交互
            //规划交互流程
            //在cookie中查找手机号
            var killPhone = $.cookie('killphone');
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            //验证手机号
            if(!seckill.validatePhone(killPhone)){
                //绑定phone 控制输出
                var killPhoneModal=$('#killPhoneModal');
                //显示弹出层
                killPhoneModal.modal({
                    show:true,//显示弹出层
                    backdrop:'static',//禁止位置关闭
                    keyboard:false//关闭键盘事件
                });
                $('#killPhoneBtn').click(function(){
                   var inputPhone=$('#killPhoneKey').val();
                   if(seckill.validatePhone(inputPhone)){
                       //电话写入cookie
                       $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                       //刷新页面
                       window.location.reload();
                   }else{
                       $('#killPhoneMessage').hide().html('').show()
                   }
                });
            }
        }
    }
}