<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>地图热点效果-鼠标经过弹出提示信息</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js" type="text/javascript"></script><!-- 建议用1.7的jquery -->
<script type="text/javascript">var jq = jQuery.noConflict();</script><!-- 为了让DZ X2支持jquery 加载时替换库中的$为jq -->
<style type="text/css">
.map img { width:496px; height: 415px; }/* 
.mapDiv { padding: 5px; width:170px; height:61px; color:#369; background: url('/jscss/demoimg/201203/hotarrow.gif') no-repeat; } */
.mapDiv {padding: 5pxlwidth:170px;height:61px; color:#369; background: url('../resources/images/qipao.gif') no-repeat;}
</style><!-- CSS样式 -->
<body>
<!-- JS 如果需要读取变量最好写在网页里,也可以写在JS文件里!-->
<script type="text/javascript">
jq(document).ready(function(){
    jQuery.fn.extend({
        TitleShow: function(strHTML) {
            var xOffset = 80;
            var yOffset = -75;
            var preview = jq("#preview_container");
            if(preview.length<=0){
                jq("body").append("<div id='preview_container'></div>");
                preview = jq("#preview_container");
            }
            preview.css({
                "display":"none",
                "position":"absolute",
                "width":"150px",
				"word-break":"break-all"
            });
            return this.each(function() {
                var _this = jq(this);
                _this.hover(
                    function(e){
                        preview.html(strHTML);
                        preview
                            .css("top",(e.pageY - xOffset) + "px")
                            .css("left",(e.pageX + yOffset) + "px")
                            .css("opaticy",0)
                            .show()
                            .stop()
                            .animate({"opacity":0.9},300);
                            
                    },function(){
                        preview
                            .stop()
                            .animate({"opacity":0},300,function(){
                                jq(this).hide();
                            });
                    }
                )
                _this.mousemove(function(e){
                    preview
                        .css("top",(e.pageY - xOffset) + "px")
                        .css("left",(e.pageX + yOffset) + "px");
                });
            });
        }
    });
    jq("#beijing").TitleShow("<div class='mapDiv'>北京地图热点效果-这里是测试换行效果-这里是测试换行效果</div>");
    jq("#tianjin").TitleShow("<div class='mapDiv'>天津地图热点效果2</div>");
    jq("#shanghai").TitleShow("<div class='mapDiv'>上海地图热点效果3</div>");
    jq("#chongqing").TitleShow("<div class='mapDiv'>重庆地图热点效果4</div>");
    jq("#hebei").TitleShow("<div class='mapDiv'>河北地图热点效果5</div>");
    jq("#shanxi").TitleShow("<div class='mapDiv'>山西地图热点效果6</div>");
    jq("#neimenggu").TitleShow("<div class='mapDiv'>内蒙古地图热点效果7</div>");
    jq("#liaoning").TitleShow("<div class='mapDiv'>地图热点效果8</div>");
    jq("#jilin").TitleShow("<div class='mapDiv'>地图热点效果9</div>");
    jq("#heilongjiang").TitleShow("<div class='mapDiv'>黑龙江地图热点效果10</div>");
    jq("#jiangsu").TitleShow("<div class='mapDiv'>地图热点效果11</div>");
    jq("#zhejiang").TitleShow("<div class='mapDiv'>地图热点效果12</div>");
    jq("#anhui").TitleShow("<div class='mapDiv'>地图热点效果13</div>");
    jq("#fujian").TitleShow("<div class='mapDiv'>地图热点效果14</div>");
    jq("#jiangxi").TitleShow("<div class='mapDiv'>地图热点效果15</div>");
    jq("#shandong").TitleShow("<div class='mapDiv'>山东地图热点效果16</div>");
    jq("#henan").TitleShow("<div class='mapDiv'>河南地图热点效果17</div>");
    jq("#hubei").TitleShow("<div class='mapDiv'>湖北地图热点效果18</div>");
    jq("#hunan").TitleShow("<div class='mapDiv'>地图热点效果l9</div>");
    jq("#guangdong").TitleShow("<div class='mapDiv'>地图热点效果20e</div>");
    jq("#guangxi").TitleShow("<div class='mapDiv'>地图热点效果21</div>");
    jq("#hainan").TitleShow("<div class='mapDiv'>地图热点效果22</div>");
    jq("#sichuan").TitleShow("<div class='mapDiv'>地图热点效果23</div>");
    jq("#guizhou").TitleShow("<div class='mapDiv'>地图热点效果24</div>");
    jq("#yunnan").TitleShow("<div class='mapDiv'>地图热点效果25</div>");
    jq("#shaanxi").TitleShow("<div class='mapDiv'>地图热点效果26</div>");
    jq("#gansu").TitleShow("<div class='mapDiv'>地图热点效果27</div>");
    jq("#qinghai").TitleShow("<div class='mapDiv'>地图热点效果28</div>");
    jq("#ningxia").TitleShow("<div class='mapDiv'>宁夏地图热点效果29</div>");
    jq("#xinjiang").TitleShow("<div class='mapDiv'>新疆地图热点效果30</div>");
    jq("#xizang").TitleShow("<div class='mapDiv'>地图热点效果31</div>");
    jq("#xianggang").TitleShow("<div class='mapDiv'>香港地图热点效果32</div>");
    jq("#aomen").TitleShow("<div class='mapDiv'>地图热点效果33</div>");
    jq("#taiwan").TitleShow("<div class='mapDiv'>地图热点效果34</div>");
});
</script>
<!--热点HTML代码开始 -->
<div class="map">
<img border="0" usemap="#Map" src="../resources/images/map.png" />
<map name="Map" id="Map">
<area id="beijing" alt="北京" href="#" coords="354,140,380,153" shape="rect">
<area id="shanghai" alt="上海" href="#" coords="434,246,462,259" shape="rect">
<area id="tianjin" alt="天津" href="#" coords="382,168,408,180" shape="rect">
<area id="chongqing" alt="重庆" href="#" coords="294,264,320,276" shape="rect">
<area id="hebei" alt="河北" href="#" coords="347,174,374,186" shape="rect">
<area id="shanxi" alt="山西"  href="#" coords="322,186,348,198" shape="rect">
<area id="neimenggu" alt="内蒙古" href="#" coords="349,110,388,124" shape="rect">
<area id="liaoning" alt="辽宁" href="#" coords="406,128,432,140" shape="rect">
<area id="jilin" alt="吉林" href="#" coords="427,101,454,115" shape="rect">
<area id="heilongjiang" alt="黑龙江" href="#" coords="424,58,464,73" shape="rect">
<area id="jiangsu" alt="江苏" href="#" coords="404,224,417,250" shape="rect">
<area id="zhejiang" alt="浙江" href="#" coords="413,265,427,291" shape="rect">
<area id="anhui" alt="安徽" href="#" coords="382,236,395,263" shape="rect">
<area id="fujian" alt="福建" href="#" coords="399,300,413,327" shape="rect">
<area id="jiangxi" alt="江西" href="#" coords="371,286,385,313" shape="rect">
<area id="shandong" alt="山东" href="#" coords="373,196,399,208" shape="rect">
<area id="henan" alt="河南" href="#" coords="337,228,364,239" shape="rect">
<area id="hubei" alt="湖北" href="#" coords="329,258,356,271" shape="rect">
<area id="hunan" alt="湖南" href="#" coords="325,294,352,306" shape="rect">
<area id="guangdong" alt="广东" href="#" coords="356,343,382,355" shape="rect">
<area id="guangxi" alt="广西" href="#" coords="302,343,328,355" shape="rect">
<area id="hainan" alt="海南" href="#" coords="313,398,340,411" shape="rect">
<area id="sichuan" alt="四川" href="#" coords="239,265,265,277" shape="rect">
<area id="guizhou" alt="贵州" href="#" coords="283,311,308,324" shape="rect">
<area id="yunnan" alt="云南" href="#" coords="225,337,251,349" shape="rect">
<area id="shaanxi" alt="陕西" href="#" coords="303,224,316,251" shape="rect">
<area id="gansu" alt="甘肃" href="#" coords="179,156,205,168" shape="rect">
<area id="qinghai" alt="青海" href="#" coords="174,206,200,218" shape="rect">
<area id="ningxia" alt="宁夏" href="#" coords="277,188,290,212" shape="rect">
<area id="xinjiang" alt="新疆" href="#" coords="85,140,111,152" shape="rect">
<area id="xizang" alt="西藏" href="#" coords="87,249,113,261" shape="rect">
<area id="xianggang" alt="香港" href="#" coords="379,358,406,370" shape="rect">
<area id="aomen" alt="澳门" href="#" coords="349,371,375,383" shape="rect">
<area id="taiwan" alt="台湾" href="#" coords="434,322,448,348" shape="rect">
</map>
</div>
</body>
</html>