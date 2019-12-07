<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'front.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script type = "text/javascript" src = "js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var largePath  = $(this).attr("href");
				var largeAlt = $(this).attr("title");
				$("#largeImg").attr({
					src : largePath,
					alt : largeAlt
				});
				return false;
			});
			
			$("#myfile").change(function(){
				$("#previewImg").attr("src","file:///" + $("#myfile").val());
			});
			
			var la = $("#large");
			la.hide();
			
			$("#previewImg").mousemove(function(e){
				la.css({
					top : e.pageY,
					left : e.pageX
				}).html('<img src = "' + this.src + '" />').show();
			}).mouseout(function(){
				la.hide();
			});
		});
	</script>
  </head>
  
  <body>
  
    <img id="previewImg" src="files/autumnLake_original.jpg" width="80" height="80" />
    
  	 <form action="fileUpload.do" method="post" enctype="multipart/form-data">
  		please make a selection : <input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
  		<input type="submit" value="submit" />${result}
  	</form>
  	
  	download : <a href="downloadServlet.do?filename=file_downloading_fromserver.txt">file_downloading_fromserver.txt</a> &nbsp;&nbsp; ${errorResult}
  	
  	<div id="large"></div>
  	
  	<hr>
    <h2>Picture preview</h2>
    <p><img id="largeImg" src="files/autumnLake_original.jpg" alt="Large Image"/></p>
    <p class="thumbs">
    	<a href="files/winterPark_original.jpg" title="winterPark"><img src="files/winterPark_thumb.jpg"></a>
    	<a href="files/snowman_original.jpg" title="snowman"><img src="files/snowman_thumb.jpg"></a>
    	<a href="files/snowDog_original.jpg" title="snowDog"><img src="files/snowDog_thumb.jpg"></a>
    	<a href="files/outdoorToronotdo_original.jpg" title="outdoorToronotdo"><img src="files/outdoorToronotdo_thumb.jpg"></a>
    	<a href="files/exoticBird_original.jpg" title="exoticBird"><img src="files/exoticBird_thumb.jpg"></a>
    </p>
  </body>
</html>
