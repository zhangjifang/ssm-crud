$.fn.extend({
    /*
       序列化成json串
     * 日期:2016-07-21
     * 作者:lianhailong
     * 用法 $("#form1").HY_SerializeJsonStr();
    */
	
   "HY_SerializeJsonStr":  function (options) {
        ////自己写的序列化
        var json = new Array();
        var $input = $(this).find("input");
        var $select = $(this).find("select");
        var $textarea = $(this).find("textarea");
        json.push("{");
        //配置参数
        options = $.extend({
            data: "",//追加的json数据
            chb_nocheckd_value: "0",//复选框未选中时初始值 默认为"0"
            select: 0//真对select获取内容 默认0获取value内容; 1:获取文本内容
        }, options);
        //返回json串
        function JsonStr(name, value) {
            var str = '"' + name + '"' + ':"' + value.replace(/\"/g, '\\"') + '"';
            json.push(str);
            json.push(",");
        }
        function Flag(name) {
            if (name == undefined || name == "__VIEWSTATE" || name == "__VIEWSTATEGENERATOR" || name == "__EVENTVALIDATION")
                return false;
            else
                return true;
        }
        $input.each(function () {
            var type = $(this).attr("type");//获取input控件的类型
            var name = $(this).attr("name");//获取name属性
            var value = $(this).val();//获取value值
            if (Flag(name)) {
                //--------复选框------//
                if (type == "checkbox") {
                    var chk_value = "0";
                    //选中获取value中的文本,否则默认为0
                    if (this.checked) {
                        chk_value = value;
                    } else {
                        chk_value = options.chb_nocheckd_value + "";
                    }
                    JsonStr(name, chk_value);
                }
                    //单选按钮
                else if (type == "radio") {
                    if (this.checked) {
                        JsonStr(name, value);
                    }
                }
                    //--------其他------//
                else {
                    JsonStr(name, value);
                }
            }
        });
        $select.each(function () {
            var name = $(this).attr("name");
            var value = "";
            //1获取text值
            if (options.select == 1)
                value = $(this).find("option:selected").text();
            else {
                value = $(this).val();//默认获取value值
            }
            if (Flag(name)) {
                JsonStr(name, value);
            }
        });
        $textarea.each(function () {
            var name = $(this).attr("name");
            var value = $(this).val();
            if (Flag(name)) {
                JsonStr(name, value);
            }
        });
        if (options.data != undefined && options.data != null && options.data != "") {
            //追加新数据
            for (var json_i in options.data) {
                JsonStr(json_i, options.data[json_i]);
            }
        }
        //移除最后一位
        if (json.length > 0)
            json.pop();

        //拼接最后一个括号
        if (json.length > 0)
            json.push("}");
        return json.join("");

    }
})