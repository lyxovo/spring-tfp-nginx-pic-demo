<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="./css/style.css" rel="stylesheet"/> -->
<script src="./js/jquery.min.js" type="text/javascript"></script>

</head>
<body>
	<h1>jQuery serialize()、serializeArray()</h1>
	<!-- 设置password 为禁用 disabled="disabled"-->
	<!-- 设置age没有name属性 -->
	<form  action="/test0.ds" method="get">
		<table>
			<tr><th>name:</th><th><input type="text" name="name"/><tr>
			<tr><th>age:</th><th><input type="text" id="age"/></th><tr>
			<tr><th>password:</th><th><input type="text"  disabled name="password"/></th><tr>
			<tr><th>email:</th><th><input type="text" name="email"/></th><tr>
			<tr><th>detail:</th><th><textarea name="detail"  rows="5" cols="20"></textarea></th><tr>
		</table>
		<input type="button" id="btn" value="提交"/>
	</form>
</body>
<script type="text/javascript">
$("form #btn").click(function(){
	//$("form").submit();
 	 $.ajax({
		url: "/test0.ds",
		//data: $("form").serialize(),
		data: $("form").serializeArray(),
		dataType: "json", 
		success: function(result){
			console.log(result)
		},
		error:function(){
			console.log("查询出现错误。");
		}
	});  
});

</script>

<!-- //jQuery.serialize()
//jQuery.serializeArray()
///https://www.cnblogs.com/sqyambition/p/8469213.html
//jquery: $("#form").submit(); -->
</html>