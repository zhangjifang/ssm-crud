/**参数说明： 
 * 解决alert阻止其他事件执行的问题。 
 * mytime 停留时间
 * pWidth 显示宽度
 * content 显示内容
 * 无返回值
 */
function tankuang(mytime,pWidth,content){
    $("#lymsg").remove();
    var html ='<div id="lymsg" style="position:fixed;top:50%;width:100%;height:30px;line-height:30px;margin-top:-15px;"><p style="background:#000;opacity:0.8;width:'+ pWidth +'px;color:#fff;text-align:center;padding:10px 10px;margin:0 auto;font-size:12px;border-radius:4px;">'+ content +'</p></div>'
    $("body").append(html);
    var t=setTimeout(next,mytime);
    function next(){
    	$("#lymsg").remove();
   	}
}